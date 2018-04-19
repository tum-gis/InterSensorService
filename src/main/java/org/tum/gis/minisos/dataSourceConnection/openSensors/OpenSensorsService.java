package org.tum.gis.minisos.dataSourceConnection.openSensors;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.dataSourceConnection.openSensors.observations.Observations;
import org.tum.gis.minisos.dataSourceConnection.openSensors.topics.Topics;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.IdSequenceManager;

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
		
		String topicUrl = openSensorsConnection.getBaseUrl()+"/topics/"+openSensorsConnection.getTopicName()+"?api-key="+openSensorsConnection.getAuthKey();
		//RestTemplate requires Get request as URI. The default conversion of string to Uri omits special or extra characters which lead to issues
		URI topicUri = new URI(topicUrl); 
		
		System.out.println(topicUri);
		
		RestTemplate restTemplateTopic = new RestTemplate();
		Topics topics = restTemplateTopic.getForObject(topicUri, Topics.class);
		
		if (topics!=null) {
			timeseriesService.timeseriesList.get(timeseriesId-1).setName(topics.getName());
			timeseriesService.timeseriesList.get(timeseriesId-1).setDescription(topics.getDescription());
			
			//Update lcoation TODO
			//Update first and last observations TODO
			timeseriesService.timeseriesList.get(timeseriesId-1).setFirstObservation("2017-01-24T23:00:00");
			timeseriesService.timeseriesList.get(timeseriesId-1).setLastObservation("2018-04-19T00:00:00");
		}
	}
	
	public List<Observation> parseOpenSensors(int timeseriesId, OpenSensorsConnection openSensorsConnection, String startTime, String endTime) throws URISyntaxException{
		
		//manipulate datetime strings, inclusion of + character is creating issues. Replace + with %2B
		
		String startTimeModified = startTime.replaceAll("\\+","%2B");
		String endTimeModified = endTime.replaceAll("\\+","%2B");
		
		String messagesUrl = openSensorsConnection.getBaseUrl()+
							 "/messages/topic/"+openSensorsConnection.getTopicName()+
							 "?api-key="+openSensorsConnection.getAuthKey()+
							 "&start-date="+startTimeModified+
							 "&end-date="+endTimeModified;
		
		
		URI messagesUri = new URI(messagesUrl);
		
		RestTemplate restTemplateMessages = new RestTemplate();
		Observations observations = restTemplateMessages.getForObject(messagesUri, Observations.class);
		
		List<Observation> observationList = new ArrayList<>();
		
		for (int i=0;i<observations.getMessages().size()-1;i++) {
			OpenSensorsObservation openSensorsObservation = new OpenSensorsObservation();
			openSensorsObservation.setTime(observations.getMessages().get(i).getDate());
			openSensorsObservation.setValue(observations.getMessages().get(i).getValue());
			
			observationList.add(openSensorsObservation);
			
		} 
		
		return observationList;
	}
}