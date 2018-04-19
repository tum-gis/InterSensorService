package org.tum.gis.minisos.dataSource.sensorThings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.dataSource.sensorThings.locations.Locations;
import org.tum.gis.minisos.dataSource.sensorThings.observations.Observations;
import org.tum.gis.minisos.dataSource.sensorThings.things.Things;
import org.tum.gis.minisos.dataSource.sensorThings.datastreams.Datastreams;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.IdSequenceManager;

@Service
public class SensorThingsService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	public void addDataSource(SensorThingsConnection sensorThingsConnection) {
		int flag = 0;
		int dataSourceId = 1;		
		for (int i=0; i<dataSourceService.datasources.size(); i++) {
			if (sensorThingsConnection.getName().equals(dataSourceService.datasources.get(i).getDataSourceConnection().getName())) {
				flag = 1;
				dataSourceId = dataSourceService.datasources.get(i).getId();
				break;
			}
		}
		
		if (flag==1) {
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,sensorThingsConnection);
			validateSensorThingsConnection(timeseriesId,sensorThingsConnection);
			seriesRestApiService.seriesRestApi52nFormatter(sensorThingsConnection);
		}
		else {
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,sensorThingsConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,sensorThingsConnection);
			validateSensorThingsConnection(timeseriesId,sensorThingsConnection);
			seriesRestApiService.seriesRestApi52nFormatter(sensorThingsConnection);
		}
	}
	
	public void validateSensorThingsConnection(int timeseriesId,SensorThingsConnection sensorThingsConnection) {
		//read SensorThings and update DataSource
		String thingUrl =  sensorThingsConnection.getBaseUrl()+"/Things("+sensorThingsConnection.getThingId()+")";
		
		RestTemplate restTemplateThing = new RestTemplate();
		Things things = restTemplateThing.getForObject(thingUrl,Things.class);
		
		if (things!=null) {
			//TODO
		}
		
		//read SensorThings and update Geometry
		String locationsUrl =  sensorThingsConnection.getBaseUrl()+"/Things("+sensorThingsConnection.getThingId()+")/Locations";
		RestTemplate restTemplateLocation = new RestTemplate();
		Locations locations = restTemplateLocation.getForObject(locationsUrl,Locations.class);
		
		if (locations!=null) {
			//seriesRestApiService.geometryList.get(0).setCoordinates(locations.getValue().get(0).getLocation().getCoordinates());
		}
		
		//read SensorThings and update DataSource
		String datastreamsUrl =  sensorThingsConnection.getBaseUrl()+"/Datastreams("+sensorThingsConnection.getDatastreamId()+")";
		RestTemplate restTemplateDatastreams = new RestTemplate();
		Datastreams datastreams = restTemplateDatastreams.getForObject(datastreamsUrl, Datastreams.class);
		
		//read SensorThings and update first and last observations
		String latestObservationsUrl =  sensorThingsConnection.getBaseUrl()+"/Datastreams("+sensorThingsConnection.getDatastreamId()+")/Observations?$top=1";
		RestTemplate restTemplateObservations = new RestTemplate();
		Observations lastestObservation = restTemplateObservations.getForObject(latestObservationsUrl, Observations.class);
		
		int totalCount = lastestObservation.getCount()-1;
		String firstObservationUrl = sensorThingsConnection.getBaseUrl()+"/Datastreams("+sensorThingsConnection.getDatastreamId()+")/Observations?$skip="+totalCount;
		Observations firstObservation = restTemplateObservations.getForObject(firstObservationUrl, Observations.class);
				
		if (datastreams!=null) {
			timeseriesService.timeseriesList.get(timeseriesId-1).setName(datastreams.getName());
			timeseriesService.timeseriesList.get(timeseriesId-1).setDescription(datastreams.getDescription());
			timeseriesService.timeseriesList.get(timeseriesId-1).setObservationType(datastreams.getObservationType());
			timeseriesService.timeseriesList.get(timeseriesId-1).setUnitOfMeasure(datastreams.getUnitOfMeasurement().getName());	
			
			//retrieve first and last observation from observation
			timeseriesService.timeseriesList.get(timeseriesId-1).setFirstObservation(firstObservation.getValue().get(0).getPhenomenonTime());
			timeseriesService.timeseriesList.get(timeseriesId-1).setLastObservation(lastestObservation.getValue().get(0).getPhenomenonTime());
		}
	}
	
	public List<Observation> parseSensorThings(int timeseriesId, SensorThingsConnection sensorThingsConnection, String startTime, String endTime){
		
		String serviceUrl = sensorThingsConnection.getBaseUrl()+
							"/Datastreams(" + sensorThingsConnection.getDatastreamId() +
							")/Observations?$filter=phenomenonTime ge '"+ startTime + 
							"' and phenomenonTime le '" + endTime + "'&$top=2000";
		
		
		
		RestTemplate restTemplateObservations = new RestTemplate();
		Observations observations = restTemplateObservations.getForObject(serviceUrl, Observations.class);
		
		List<Observation> observationList = new ArrayList<>();
		
		//SensorThings API returns maximum 2000 observations in one single response.
		if (observations.getCount()<=2000) {
			for (int i=0;i<observations.getValue().size()-1;i++) {
				SensorThingsObservation sensorThingsObservation = new SensorThingsObservation();
				sensorThingsObservation.setTime(observations.getValue().get(i).getPhenomenonTime());
				sensorThingsObservation.setValue(Double.parseDouble(observations.getValue().get(i).getResult()));
				
				
				observationList.add(sensorThingsObservation);
			}
		}
		else {
			int iterations = (observations.getCount()/2000)+1;
			for (int j=1;j<iterations-1;j++) {
				String serviceUrlPart = sensorThingsConnection.getBaseUrl()+
						"/Datastreams(" + sensorThingsConnection.getDatastreamId() +
						")/Observations?$filter=phenomenonTime ge '"+ startTime + 
						"' and phenomenonTime le '" + endTime + "'&$top=2000&$skip="+j*2000;
				
				Observations observationsPart = restTemplateObservations.getForObject(serviceUrlPart, Observations.class);
				
				for (int i=0;i<observationsPart.getValue().size();i++) {
					SensorThingsObservation sensorThingsObservation = new SensorThingsObservation();
					sensorThingsObservation.setTime(observationsPart.getValue().get(i).getPhenomenonTime());
					sensorThingsObservation.setValue(Double.parseDouble(observationsPart.getValue().get(i).getResult()));					
					
					observationList.add(sensorThingsObservation);
				}
			}
		}
		
		
		
		
		return observationList;
	}
	

	
}
