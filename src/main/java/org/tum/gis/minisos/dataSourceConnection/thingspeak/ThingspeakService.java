/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.thingspeak;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationListManager;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.IdSequenceManager;

/**
 * @author kchaturvedi
 *
 */
@Service
public class ThingspeakService {
	
	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;

	//private static final Logger log = LoggerFactory.getLogger(ThingspeakService.class);
	
	/*public static void main(String args[]) {
		 String serviceUrl = "https://thingspeak.com/channels/"+64242+"/feeds/"+1+".json";
		RestTemplate restTemplate = new RestTemplate();
        ThingspeakResponse thingspeakResponse = restTemplate.getForObject("https://thingspeak.com/channels/64242/fields/2.json", ThingspeakResponse.class);
        //log.info(thingspeakResponse.toString());
		//String s = "25.0/n";
		//s = s.replaceAll("[^\\d.]", "");
		//double d = Double.parseDouble(s);
        //System.out.println(thingspeakResponse.getFeed().get(0).getField1());
        System.out.println(serviceUrl);
		//System.out.println(d);
    }*/
	
	public void addDataSource(ThingspeakConnection thingspeakConnection) {
		
		int flag = 0;
		int dataSourceId = 1;
		
		for (int i=0; i<dataSourceService.datasources.size(); i++) {
			if(thingspeakConnection.getName().equals(dataSourceService.datasources.get(i).getDataSourceConnection().getName())) {
				flag = 1;
				dataSourceId = dataSourceService.datasources.get(i).getId();
				break;
			}
		}
		
		if (flag==1) {
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,thingspeakConnection);
			validateThingspeakConnection(timeseriesId,thingspeakConnection);
		}
		else {
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,thingspeakConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,thingspeakConnection);
			validateThingspeakConnection(timeseriesId,thingspeakConnection);
		}
		
	}
	
	public void validateThingspeakConnection(int timeseriesId, ThingspeakConnection thingspeakConnection) {
		 String serviceUrl = "https://thingspeak.com/channels/"+thingspeakConnection.getChannel()+"/fields/"+thingspeakConnection.getfield()+".json";
		 RestTemplate restTemplate = new RestTemplate();
		 ThingspeakResponse thingspeakResponse = restTemplate.getForObject(serviceUrl, ThingspeakResponse.class);
		 
		 if (thingspeakResponse!=null) {
			 timeseriesService.timeseriesList.get(timeseriesId-1).setName(thingspeakResponse.getChannel().getName());
			 timeseriesService.timeseriesList.get(timeseriesId-1).setDescription(thingspeakResponse.getChannel().getDescription());
			 timeseriesService.timeseriesList.get(timeseriesId-1).setFirstObservation(thingspeakResponse.getChannel().getCreated_at());
			 timeseriesService.timeseriesList.get(timeseriesId-1).setLastObservation(thingspeakResponse.getChannel().getUpdated_at());
		 }
	}
	
	public List<Observation> parseThingspeak(int timeseriesId, ThingspeakConnection thingspeakConnection) {
		 String serviceUrl = "https://thingspeak.com/channels/"+thingspeakConnection.getChannel()+"/fields/"+thingspeakConnection.getfield()+".json";
		 RestTemplate restTemplate = new RestTemplate();
		 ThingspeakResponse thingspeakResponse = restTemplate.getForObject(serviceUrl, ThingspeakResponse.class);
		 
		 //List<ThingspeakObservation> thingspeakObservationList = new ArrayList<>();
		 List<Observation> observationList = new ArrayList<>();
		 
		 for (int i=0;i<thingspeakResponse.getFeed().size();i++) {
			 ThingspeakObservation thingspeakObservation = new ThingspeakObservation();
			 thingspeakObservation.setTime(thingspeakResponse.getFeed().get(i).getCreated_at());
			 if (thingspeakConnection.getfield()==1) {
				 thingspeakObservation.setValue(thingspeakResponse.getFeed().get(i).getField1());
			 }else {
				 thingspeakObservation.setValue(thingspeakResponse.getFeed().get(i).getField2());
			 }
			 
			 
			 observationList.add(thingspeakObservation);			 
		 }
		 
		 return observationList;
		 /*ObservationListManager observationListManager = new ObservationListManager(timeseriesId,observationList3);
         observationService.observationList.add(observationListManager);*/
         
	}
	
	public List<Observation> parseThingspeak(int timeseriesId, ThingspeakConnection thingspeakConnection, String startTime, String endTime) {
		 String serviceUrl = "https://thingspeak.com/channels/"+thingspeakConnection.getChannel()+"/fields/"+thingspeakConnection.getfield()+".json?start="+startTime+"&end="+endTime;
		 RestTemplate restTemplate = new RestTemplate();
		 ThingspeakResponse thingspeakResponse = restTemplate.getForObject(serviceUrl, ThingspeakResponse.class);
		 
		 //List<ThingspeakObservation> thingspeakObservationList = new ArrayList<>();
		 List<Observation> observationList = new ArrayList<>();
		 
		 for (int i=0;i<thingspeakResponse.getFeed().size();i++) {
			 ThingspeakObservation thingspeakObservation = new ThingspeakObservation();
			 thingspeakObservation.setTime(thingspeakResponse.getFeed().get(i).getCreated_at());
			 if (thingspeakConnection.getfield()==1) {
				 thingspeakObservation.setValue(thingspeakResponse.getFeed().get(i).getField1());
			 }else {
				 thingspeakObservation.setValue(thingspeakResponse.getFeed().get(i).getField2());
			 }
			 
			 
			 observationList.add(thingspeakObservation);			 
		 }
		 
		 return observationList;
		 /*ObservationListManager observationListManager = new ObservationListManager(timeseriesId,observationList3);
        observationService.observationList.add(observationListManager);*/
        
	}
	
	
}

