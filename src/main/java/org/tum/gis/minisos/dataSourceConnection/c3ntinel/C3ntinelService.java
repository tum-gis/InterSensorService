package org.tum.gis.minisos.dataSourceConnection.c3ntinel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.dataSourceConnection.c3ntinel.meter.Meter;
import org.tum.gis.minisos.dataSourceConnection.c3ntinel.readings.C3ntinelReadings;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.CustomDateUtil;
import org.tum.gis.minisos.util.IdSequenceManager;

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
	
	public void addDataSource(C3ntinelConnection c3ntinelConnection) throws ParseException {
		
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
		}
		else {
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,c3ntinelConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId, dataSourceId, c3ntinelConnection);
			validateC3ntinelConnection(timeseriesId,c3ntinelConnection);
			seriesRestApiService.seriesRestApi52nFormatter(c3ntinelConnection);
		}
	}
	
	public void validateC3ntinelConnection(int timeseriesId, C3ntinelConnection c3ntinelConnection) throws ParseException {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		String notEncoded = c3ntinelConnection.getUsername()+":"+c3ntinelConnection.getPassword();
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		
		String authString = "Basic "+encodedAuth;
		
		String meterUrl = c3ntinelConnection.getBaseUrl()+"/"+"meter"+"/"+c3ntinelConnection.getMeterId();
		String readingUrl = meterUrl+"/"+"readings"+"?"+"resolution"+"="+c3ntinelConnection.getResolution().toUpperCase();
		
		headers.set("Accept", "application/json");
		headers.set("Authorization", authString);
		
	    HttpEntity entity = new HttpEntity(headers);
	    
	    ResponseEntity<Meter> meterResponse = restTemplate.exchange(meterUrl, HttpMethod.GET, entity, Meter.class);
	    ResponseEntity<C3ntinelReadings> readingResponse = restTemplate.exchange(readingUrl, HttpMethod.GET, entity, C3ntinelReadings.class);
	    
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
		coordinates.add(meterResponse.getBody().getLocation().getLongitude());
		coordinates.add(meterResponse.getBody().getLocation().getLatitude());
		
		dataSourceService.datasources.get(0).setCoordinates(coordinates);
	}
	
	public List<Observation> parseC3ntinel(int timeseriesId, C3ntinelConnection c3ntinelConnection, String startTime, String endTime) throws ParseException{
		
		List<Observation> observationList = new ArrayList<>();
		
		String startTimeModified = startTime.substring(0, 19)+".000Z";
		String endTimeModified = endTime.substring(0, 19)+".000Z";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		String notEncoded = c3ntinelConnection.getUsername()+":"+c3ntinelConnection.getPassword();
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		
		String authString = "Basic "+encodedAuth;
		
		String meterUrl = c3ntinelConnection.getBaseUrl()+"/"+"meter"+"/"+c3ntinelConnection.getMeterId();
		String readingUrl = meterUrl+"/"+"readings"+"?"+"resolution"+"="+c3ntinelConnection.getResolution().toUpperCase()
							+"&start_date="+startTimeModified+"&end_date="+endTimeModified;
		
		headers.set("Accept", "application/json");
		headers.set("Authorization", authString);
		
	    HttpEntity entity = new HttpEntity(headers);
	    
	   // ResponseEntity<Meter> meterResponse = restTemplate.exchange(meterUrl, HttpMethod.GET, entity, Meter.class);
	    ResponseEntity<C3ntinelReadings> readingResponse = restTemplate.exchange(readingUrl, HttpMethod.GET, entity, C3ntinelReadings.class);
	    
	   for (int i=0; i<readingResponse.getBody().getReadings().size();i++) {
		   C3ntinelObservation c3ntinelObservation = new C3ntinelObservation();
		   
		   c3ntinelObservation.setTime(CustomDateUtil.UnixToDateConvertor(readingResponse.getBody().getReadings().get(i).getTime()));
		   c3ntinelObservation.setValue(readingResponse.getBody().getReadings().get(i).getValue());
		   
		   observationList.add(c3ntinelObservation);
	   }
	    
	    return observationList;
	}
	
	
}
