package org.tum.gis.interSensorService.dataSourceConnection.c3ntinel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.interSensorService.dataSource.DataSource;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.meter.Meter;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.readings.C3ntinelReadings;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.SensorThingsApiService;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.interSensorService.observation.Observation;
import org.tum.gis.interSensorService.observation.ObservationService;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;
import org.tum.gis.interSensorService.util.CustomDateUtil;
import org.tum.gis.interSensorService.util.IdSequenceManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class C3ntinelService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	@Autowired
	private SensorThingsApiService sensorThingsApiService;
	
	public void addDataSource(C3ntinelConnection c3ntinelConnection) throws ParseException, JsonProcessingException, URISyntaxException, IOException {
		
		int flag = 0;
		int dataSourceId = 1;	
		
		for (int i=0; i<dataSourceService.datasources.size(); i++) {
			if(c3ntinelConnection.getName().equals(dataSourceService.datasources.get(i).getDataSourceConnection().getName())) {
				flag = 1;
				dataSourceId = dataSourceService.datasources.get(i).getId();
				break;
			}
		}
		
		if (flag==1) {
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId, dataSourceId, c3ntinelConnection);
			validateC3ntinelConnection(timeseriesId,c3ntinelConnection);
			seriesRestApiService.seriesRestApi52nFormatter(c3ntinelConnection);
			sensorThingsApiService.SensorThingsApiFormatter(c3ntinelConnection);
		}
		else {
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,c3ntinelConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId, dataSourceId, c3ntinelConnection);
			validateC3ntinelConnection(timeseriesId,c3ntinelConnection);
			seriesRestApiService.seriesRestApi52nFormatter(c3ntinelConnection);
			sensorThingsApiService.SensorThingsApiFormatter(c3ntinelConnection);
		}
	}
	
	public void validateC3ntinelConnection(int timeseriesId, C3ntinelConnection c3ntinelConnection) throws ParseException, URISyntaxException, JsonProcessingException, IOException {
		
		RestTemplate restTemplate = new RestTemplate();
	
		
		
		//This connection involves OAuth2.0 Authorization - it generates an Access Token based on Client ID and Clinet Secret
		//The message body can be retieved by another request using the generated access token
		
		//Step 1: Generate an Access Token
		
		//Get username and password and generate Base 64 encoding to use in the Authorization Header
		String notEncoded = c3ntinelConnection.getUsername()+":"+c3ntinelConnection.getPassword();
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		
		String authBasicString = "Basic "+encodedAuth;
		
		String tokenUrl = "******";
		URI tokenUri = new URI(tokenUrl);
		
		HttpHeaders tokenRequestHeader = new HttpHeaders();
		tokenRequestHeader.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		tokenRequestHeader.set("Authorization", authBasicString);
		
		MultiValueMap<String, String> tokenRequestBody= new LinkedMultiValueMap<String, String>();
		tokenRequestBody.add("grant_type", "client_credentials");
		
		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<MultiValueMap<String, String>>(tokenRequestBody, tokenRequestHeader);
		ResponseEntity<String> tokenResponse = restTemplate.postForEntity( tokenUri, tokenRequest , String.class );
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonTextResponse = mapper.readTree(tokenResponse.getBody());
		String accessToken = jsonTextResponse.get("access_token").toString().replace("\"", "");
		//Step 2: Send a request to the API with access token as Bearer in the header
		
		HttpHeaders messageHeader = new HttpHeaders();
		String authBearerString = "Bearer "+accessToken;
		
		messageHeader.set("Accept", "application/json");
	   
		messageHeader.set("Authorization", authBearerString);
		
	    HttpEntity messageEntity = new HttpEntity(messageHeader);
		
		
	    
		String meterUrl = c3ntinelConnection.getBaseUrl()+"/"+"meter"+"/"+c3ntinelConnection.getMeterId();
		String readingUrl = meterUrl+"/"+"readings"+"?"+"resolution"+"="+c3ntinelConnection.getResolution().toUpperCase();
		
	    
	    ResponseEntity<Meter> meterResponse = restTemplate.exchange(meterUrl, HttpMethod.GET, messageEntity, Meter.class);
	    ResponseEntity<C3ntinelReadings> readingResponse = restTemplate.exchange(readingUrl, HttpMethod.GET, messageEntity, C3ntinelReadings.class);
	    
	    timeseriesService.timeseriesList.get(timeseriesId-1).setName(meterResponse.getBody().getName());
	    timeseriesService.timeseriesList.get(timeseriesId-1).setDescription(meterResponse.getBody().getDetails());
	    
	  //Update first and last observations
	    timeseriesService.timeseriesList.get(timeseriesId-1).setFirstObservation(
	    		CustomDateUtil.UnixToDateConvertor(readingResponse.getBody().getSummaryInfo().getMinReading().getTime())
	    		);
	    
	    timeseriesService.timeseriesList.get(timeseriesId-1).setLastObservation(
	    		CustomDateUtil.UnixToDateConvertor(readingResponse.getBody().getSummaryInfo().getMaxReading().getTime())
	    		);
	    
	  //location
		List<Double> coordinates = new ArrayList<>();
		//Use below commands when C3NTINEL API supports locations
		//coordinates.add(meterResponse.getBody().getLocation().getLongitude());
		//coordinates.add(meterResponse.getBody().getLocation().getLatitude());
		
		coordinates.add(c3ntinelConnection.getLongitude());
		coordinates.add(c3ntinelConnection.getLatitude());
		
		dataSourceService.datasources.get(0).setCoordinates(coordinates);
	}
	
	public List<Observation> parseC3ntinel(int timeseriesId, C3ntinelConnection c3ntinelConnection, String startTime, String endTime) throws ParseException, JsonProcessingException, IOException, URISyntaxException{
		
		List<Observation> observationList = new ArrayList<>();
		
		String startTimeModified = startTime.substring(0, 19)+".000Z";
		String endTimeModified = endTime.substring(0, 19)+".000Z";
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		//This connection involves OAuth2.0 Authorization - it generates an Access Token based on Client ID and Clinet Secret
		//The message body can be retieved by another request using the generated access token
				
		//Step 1: Generate an Access Token
				
		//Get username and password and generate Base 64 encoding to use in the Authorization Header
		String notEncoded = c3ntinelConnection.getUsername()+":"+c3ntinelConnection.getPassword();
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
			
		String authBasicString = "Basic "+encodedAuth;
				
		String tokenUrl = "*****";
		URI tokenUri = new URI(tokenUrl);
				
		HttpHeaders tokenRequestHeader = new HttpHeaders();
		tokenRequestHeader.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		tokenRequestHeader.set("Authorization", authBasicString);
				
		MultiValueMap<String, String> tokenRequestBody= new LinkedMultiValueMap<String, String>();
		tokenRequestBody.add("grant_type", "client_credentials");
		
		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<MultiValueMap<String, String>>(tokenRequestBody, tokenRequestHeader);
		ResponseEntity<String> tokenResponse = restTemplate.postForEntity( tokenUri, tokenRequest , String.class );
				
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonTextResponse = mapper.readTree(tokenResponse.getBody());
		String accessToken = jsonTextResponse.get("access_token").toString().replace("\"", "");
		
		//Step 2: Send a request to the API with access token as Bearer in the header
		
		HttpHeaders messageHeader = new HttpHeaders();
		String authBearerString = "Bearer "+accessToken;
		
		messageHeader.set("Accept", "application/json");
		messageHeader.set("Authorization", authBearerString);
		
	    HttpEntity messageEntity = new HttpEntity(messageHeader);
	    
		
		
		String meterUrl = c3ntinelConnection.getBaseUrl()+"/"+"meter"+"/"+c3ntinelConnection.getMeterId();
		String readingUrl = meterUrl+"/"+"readings"+"?"+"resolution"+"="+c3ntinelConnection.getResolution().toUpperCase()
							+"&start_date="+startTimeModified+"&end_date="+endTimeModified;
		
		
		
	    ResponseEntity<C3ntinelReadings> readingResponse = restTemplate.exchange(readingUrl, HttpMethod.GET, messageEntity, C3ntinelReadings.class);
	    
	   for (int i=0; i<readingResponse.getBody().getReadings().size();i++) {
		   C3ntinelObservation c3ntinelObservation = new C3ntinelObservation();
		   
		   c3ntinelObservation.setTime(CustomDateUtil.UnixToDateConvertor(readingResponse.getBody().getReadings().get(i).getTime()));
		   c3ntinelObservation.setValue(readingResponse.getBody().getReadings().get(i).getValue());
		   
		   observationList.add(c3ntinelObservation);
	   }
	    
	    return observationList;
	}
	
	
}
