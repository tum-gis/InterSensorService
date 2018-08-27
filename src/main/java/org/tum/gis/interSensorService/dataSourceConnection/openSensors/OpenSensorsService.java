package org.tum.gis.interSensorService.dataSourceConnection.openSensors;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.interSensorService.dataSource.DataSource;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.dataSourceConnection.openSensors.observations.Observations;
import org.tum.gis.interSensorService.dataSourceConnection.openSensors.topics.Topics;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.interSensorService.observation.Observation;
import org.tum.gis.interSensorService.observation.ObservationService;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;
import org.tum.gis.interSensorService.util.IdSequenceManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OpenSensorsService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	public void addDataSource(OpenSensorsConnection openSensorsConnection) throws URISyntaxException {
		int flag = 0;
		int dataSourceId = 1;		
		for (int i=0; i<dataSourceService.datasources.size(); i++) {
			if (openSensorsConnection.getName().equals(dataSourceService.datasources.get(i).getDataSourceConnection().getName())) {
				flag = 1;
				dataSourceId = dataSourceService.datasources.get(i).getId();
				break;
			}
		}
		
		if (flag==1) {
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,openSensorsConnection);
			validateOpenSensorsConnection(timeseriesId,openSensorsConnection);
			seriesRestApiService.seriesRestApi52nFormatter(openSensorsConnection);
		}
		else {
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,openSensorsConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,openSensorsConnection);
			validateOpenSensorsConnection(timeseriesId,openSensorsConnection);
			seriesRestApiService.seriesRestApi52nFormatter(openSensorsConnection);
		}
	}
	
	public void validateOpenSensorsConnection(int timeseriesId, OpenSensorsConnection openSensorsConnection) throws URISyntaxException {
		// read topic and validate
		
		String topicUrl = openSensorsConnection.getBaseUrl()+"/v1/topics/"+openSensorsConnection.getTopicName()+"?api-key="+openSensorsConnection.getAuthKey();
		//RestTemplate requires Get request as URI. The default conversion of string to Uri omits special or extra characters which lead to issues
		URI topicUri = new URI(topicUrl); 
		
		
		
		RestTemplate restTemplateTopic = new RestTemplate();
		Topics topics = restTemplateTopic.getForObject(topicUri, Topics.class);
		
		if (topics!=null) {
			timeseriesService.timeseriesList.get(timeseriesId-1).setName(topics.getName());
			timeseriesService.timeseriesList.get(timeseriesId-1).setDescription(topics.getDescription());
			
			//Update lcoation TODO
			//Update first and last observations TODO
			//timeseriesService.timeseriesList.get(timeseriesId-1).setFirstObservation("2017-01-24T23:00:00");
			//timeseriesService.timeseriesList.get(timeseriesId-1).setLastObservation("2018-04-19T00:00:00");
			
			//location
			List<Double> coordinates = new ArrayList<>();
			coordinates.add(topics.getStats().getLocation().getLon());
			coordinates.add(topics.getStats().getLocation().getLat());
			
			dataSourceService.datasources.get(0).setCoordinates(coordinates);
			
			//update location for 52 North REST API
			//seriesRestApiService.geometryList.get(0).setCoordinates(coordinates);
		}
	}
	
	public List<Observation> parseOpenSensors(int timeseriesId, OpenSensorsConnection openSensorsConnection, String startTime, String endTime) throws URISyntaxException, JsonProcessingException, IOException{
		
		//manipulate datetime strings, inclusion of + character is creating issues. Replace + with %2B
		
		String startTimeModified = startTime.replaceAll("\\+","%2B");
		String endTimeModified = endTime.replaceAll("\\+","%2B");
		
		/*String messagesUrl = openSensorsConnection.getBaseUrl()+
							 "/v1/messages/topic/"+openSensorsConnection.getTopicName()+							
							 "?start-date="+startTimeModified+
							 "&end-date="+endTimeModified+
							  "&api-key="+openSensorsConnection.getAuthKey();*/
		
		List<Observation> observationList = new ArrayList<>();
		//OpenSensors API responds with only 1000 messages at once and gives a "next" link for another set of 1000 messages.
		
		// A handler is required to handle such paginations
		
		String nextLink = "/v1/messages/topic/"+openSensorsConnection.getTopicName()+							
				 "?start-date="+startTimeModified+
				 "&end-date="+endTimeModified;
		
		while (nextLink != null) {
			String messagesUrl = openSensorsConnection.getBaseUrl()+nextLink+"&api-key="+openSensorsConnection.getAuthKey();
		
		
		URI messagesUri = new URI(messagesUrl);
		
		RestTemplate restTemplateMessages = new RestTemplate();
		Observations observations = restTemplateMessages.getForObject(messagesUri, Observations.class);
		

		
		
		
		// call a function to update observationList for first link and then for every next link
		String observationProperty = timeseriesService.timeseriesList.get(0).getObservationProperty();
		
		for (int i=0;i<observations.getMessages().size()-1;i++) {
			OpenSensorsObservation openSensorsObservation = new OpenSensorsObservation();
			
			//Message text as JSON response
			String textResponse = observations.getMessages().get(i).getPayload().getText();
			
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonTextResponse = mapper.readTree(textResponse);		
			
			//handler for Bat counts (Have to be refined later)
			if (observationProperty=="count") {
				Double observationValue = 1.0;
				openSensorsObservation.setTime(observations.getMessages().get(i).getDate());
				openSensorsObservation.setValue(observationValue);
				observationList.add(openSensorsObservation);
			}
			
			else {
				JsonNode observationResponse = jsonTextResponse.get(observationProperty);
				
				if (observationResponse!=null) {
					Double observationValue = observationResponse.asDouble();
					openSensorsObservation.setTime(observations.getMessages().get(i).getDate());
					openSensorsObservation.setValue(observationValue);
					observationList.add(openSensorsObservation);
				}	
			}
			
					
			
			
		} 
		nextLink = observations.getNext();
		}
		
		return observationList;
	}
}
