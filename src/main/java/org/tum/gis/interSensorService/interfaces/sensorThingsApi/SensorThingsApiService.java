/*
 * InterSensor Service
 * http://www.intersensorservice.org/
 * 
 * Copyright 2018
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 * 
 * The InterSensor Service has been developed by
 * Kanishk Chaturvedi and Thomas H. Kolbe
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.tum.gis.interSensorService.interfaces.sensorThingsApi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.dataSourceConnection.DataSourceConnection;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.datastreams.Datastream;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.datastreams.Datastreams;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.datastreams.UnitOfMeasurement;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.featuresOfInterest.FeatureOfInterest;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.featuresOfInterest.FeaturesOfInterest;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.historicalLocations.HistoricalLocation;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.historicalLocations.HistoricalLocations;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.locations.Coordinates;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.locations.Location;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.locations.Locations;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.observations.Observation;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.observations.Observations;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.observedProperties.ObservedProperties;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.observedProperties.ObservedProperty;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.sensors.Sensor;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.sensors.Sensors;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.things.Thing;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.things.Things;
import org.tum.gis.interSensorService.observation.ObservationService;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;
import org.tum.gis.interSensorService.util.SpringHost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SensorThingsApiService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	public List<Thing> thingList = new ArrayList<>();
	public List<Location> locationList = new ArrayList<>();
	public List<HistoricalLocation> historicalLocationList = new ArrayList<>();
	public List<Datastream> datastreamList = new ArrayList<>();
	public List<Sensor> sensorList = new ArrayList<>();
	public List<ObservedProperty> observedPropertyList = new ArrayList<>();
	//public List<Observation> observationList = new ArrayList<>();
	public List<FeatureOfInterest> featureOfInterestList = new ArrayList<>();
	
	
	public String rootUrl() throws UnknownHostException, FileNotFoundException {
		return "http://"+SpringHost.getHostAddress()+":"+SpringHost.getPort()+"/OGCSensorThingsApi/v1.0/";
	}
	
	public SensorThingsApi getSensorThingsApi() throws UnknownHostException, FileNotFoundException {
		//String rootUrl = "http://"+SpringHost.getHostAddress()+":"+SpringHost.getPort()+"/OGCSensorThingsApi/v1.0/";
		SensorThingsNode node1 = new SensorThingsNode("Things", rootUrl()+"Things");
		SensorThingsNode node2 = new SensorThingsNode("Locations", rootUrl()+"Locations");
		SensorThingsNode node3 = new SensorThingsNode("HistoricalLocations", rootUrl()+"HistoricalLocations");
		SensorThingsNode node4 = new SensorThingsNode("Datastreams", rootUrl()+"Datastreams");
		SensorThingsNode node5 = new SensorThingsNode("Sensors", rootUrl()+"Sensors");
		SensorThingsNode node6 = new SensorThingsNode("Observations", rootUrl()+"Observations");
		SensorThingsNode node7 = new SensorThingsNode("ObservedProperties", rootUrl()+"ObservedProperties");
		SensorThingsNode node8 = new SensorThingsNode("FeaturesOfInterest", rootUrl()+"FeaturesOfInterest");
		
		
		List<SensorThingsNode> allNodes = new ArrayList<>(Arrays.asList(node1,node2,node3,node4,node5,node6,node7,node8));
		
		SensorThingsApi sensorThingsApi = new SensorThingsApi(allNodes);
		return sensorThingsApi;
	}
	
	public void SensorThingsApiFormatter(DataSourceConnection dataSource) throws UnknownHostException, FileNotFoundException {
		
		//Create a Thing
		Thing thing = new Thing();
		
		thing.setId(dataSourceService.getAllDataSources().get(0).getId());
		String thingUrl = rootUrl()+"Things("+thing.getId()+")";
		
		thing.setSelfLink(thingUrl);
		thing.setDescription(dataSource.getDescription());
		thing.setName(dataSource.getName());
		thing.setDatastreams(thingUrl+"/Datastreams");
		thing.setHistoricalLocations(thingUrl+"/HistoricalLocations");
		thing.setLocations(thingUrl+"/Locations");
		
		//Create a Location
		Location location = new Location();
		location.setId(dataSourceService.getAllDataSources().get(0).getId());
		String locationUrl = rootUrl()+"Locations("+location.getId()+")";
		
		location.setSelfLink(locationUrl);
		location.setDescription("Description of the location");
		location.setName("Name of the location");
		location.setEncodingType("application/vnd.geo+json");
		
		
		Coordinates coordinates = new Coordinates(dataSourceService.getAllDataSources().get(0).getCoordinates());
		location.setLocation(coordinates);
		location.setType("Point");
		
		location.setThings(locationUrl+"/Things");
		location.setHistoricalLocations(locationUrl+"/HistoricalLocations");
		
		//Create a HistoricalLocation
		//TODO
		HistoricalLocation historicalLocation = new HistoricalLocation();
		
		//Create a Datastream
		Datastream datastream = new Datastream();
		datastream.setId(timeseriesService.getTimeseriesById(dataSourceService.getAllDataSources().get(0).getId()).getId());
		String datastreamUrl = rootUrl()+"Datatreams("+datastream.getId()+")";
		datastream.setSelfLink(datastreamUrl);
		datastream.setDescription(timeseriesService.getTimeseriesById(datastream.getId()).getDescription());
		datastream.setName(timeseriesService.getTimeseriesById(datastream.getId()).getName());
		datastream.setObservationType(timeseriesService.getTimeseriesById(datastream.getId()).getObservationType());
		UnitOfMeasurement uom = new UnitOfMeasurement(timeseriesService.getTimeseriesById(datastream.getId()).getUnitOfMeasure(),
													 timeseriesService.getTimeseriesById(datastream.getId()).getUnitOfMeasure(),
													 "Description about Unit Of Measurement");
		datastream.setUnitOfMeasurement(uom);
		datastream.setObservations(datastreamUrl+"/Observations");
		datastream.setObservedProperty(datastreamUrl+"/ObservedProperty");
		datastream.setSensor(datastreamUrl+"/Sensor");
		datastream.setThing(datastreamUrl+"/Thing");
		
		//Create a sensor
		Sensor sensor = new Sensor();
		sensor.setId(dataSourceService.getAllDataSources().get(0).getId());
		String sensorUrl = rootUrl()+"Sensors("+sensor.getId()+")";
		sensor.setSelfLink(sensorUrl);
		sensor.setDescription(timeseriesService.getTimeseriesById(datastream.getId()).getDescription());
		sensor.setName(timeseriesService.getTimeseriesById(datastream.getId()).getName());
		sensor.setEncodingType("text/plain");
		sensor.setMetadata(null);
		sensor.setDatastreams(sensorUrl+"/Datastreams");
		
		//Create an ObservedProperty
		ObservedProperty observedProperty = new ObservedProperty();
		observedProperty.setId(timeseriesService.getTimeseriesById(dataSourceService.getAllDataSources().get(0).getId()).getId());
		String observedPropertyUrl = rootUrl()+"ObservedProperties("+observedProperty.getId()+")";
		observedProperty.setSelfLink(observedPropertyUrl);
		observedProperty.setDescription("Description about Observed Property");
		observedProperty.setDefinition("Definition of Observed Property");
		observedProperty.setName(timeseriesService.getTimeseriesById(datastream.getId()).getObservationProperty());
		observedProperty.setDatastreams(observedPropertyUrl+"/Datastreams");
		
		//Create a FeatureOfInterest
		FeatureOfInterest featureOfInterest = new FeatureOfInterest();
		featureOfInterest.setId(dataSourceService.getAllDataSources().get(0).getId());
		String featureOfInterestUrl = rootUrl()+"FeaturesOfInterest("+featureOfInterest.getId()+")";
		featureOfInterest.setSelfLink(featureOfInterestUrl);
		featureOfInterest.setDescription(location.getDescription());
		featureOfInterest.setName(location.getName());
		featureOfInterest.setEncodingType(location.getEncodingType());
		featureOfInterest.setFeature(location.getLocation());
		featureOfInterest.setType(location.getType());
		featureOfInterest.setObservations(featureOfInterestUrl+"/Observations");
		
		
		thingList.add(thing);
		locationList.add(location);
		//historicalLocationList.add(historicalLocation);
		datastreamList.add(datastream);
		sensorList.add(sensor);
		observedPropertyList.add(observedProperty);
		featureOfInterestList.add(featureOfInterest);
	}
	
	public Things getThings(){
		Things things = new Things();
		things.setCount(thingList.size());
		things.setValue(thingList);
		return things;
	}
	
	public Thing getThingById(int id) throws UnknownHostException, FileNotFoundException {
		for (int i=0; i<=thingList.size(); i++) {
			if (thingList.get(i).getId()==id) {
				return thingList.get(i);	
			}
		}
		return null;
		
	}
	
	public Object getThingByIdQueriedSelect(int id, String select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		
		Thing thing = getThingById(id);
		Map<String,Object> mapper = new HashMap<>();
		
				
			List<String> selectParams = Arrays.asList(select.split(","));			
			for (int i=0;i<selectParams.size();i++) {
				String selectStr = selectParams.get(i).substring(0, 1).toLowerCase()+selectParams.get(i).substring(1);
				Object value = PropertyUtils.getProperty(thing, selectStr);
				Field field = Thing.class.getDeclaredField(selectStr);
				if (field.isAnnotationPresent(JsonProperty.class)) {
					String annotationValue = field.getAnnotation(JsonProperty.class).value();
					mapper.put(annotationValue, value);
				}
				else {
					mapper.put(field.getName(), value);
				}
				//mapper.put(field.toString(), value);
			}
		
		
		return mapper;
		
	}
	
	public Object getThingByIdQueriedExpanded(int id, String expanded) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		Thing thing = getThingById(id);
		Map<String,Object> mapper = new HashMap<>();
		
		List<String> expandedParams = Arrays.asList(expanded.split(","));
		for (int i=0;i<expandedParams.size();i++) {
			Field[] fields = Thing.class.getFields();
			switch(expandedParams.get(i)) {
			case "Locations":
				Locations locations = getLocations();
				mapper.put("Locations", locations.getValue());
				for (Field field:fields) {
					Object value = PropertyUtils.getProperty(thing,field.getName());

					if(!field.getName().equals(expandedParams.get(i).toLowerCase())) {
						if (field.isAnnotationPresent(JsonProperty.class)) {
							String annotationValue = field.getAnnotation(JsonProperty.class).value();	
							mapper.put(annotationValue, value);
						}
						else {
							mapper.put(field.getName(), value);
						}
					}
					
				}
					
				
			}
				
		}
		return mapper;
		
	}
	
	public Object getThingByIdQueried(int id, String expanded, String select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		Map<String,Object> mapper = new HashMap<>();
		ObjectMapper oMapper = new ObjectMapper();
		
		
		Object obj1 = getThingByIdQueriedExpanded(id,expanded);
		Object obj2 = getThingByIdQueriedSelect(id,select.toLowerCase());
		Map<String, Object> map = oMapper.convertValue(obj1, Map.class);
		
		
		List<String> expandedParams = Arrays.asList(expanded.split(","));
		List<String> selectParams = Arrays.asList(select.split(","));	
		
		for (int i=0;i<selectParams.size();i++) {
			if (!map.get(selectParams.get(i)).equals(null)) {
				mapper.put(selectParams.get(i), map.get(selectParams.get(i)));
			}
		}
		
		
		return mapper;
		
	}
	
	public Locations getLocations(){
		Locations locations = new Locations();
		locations.setCount(locationList.size());
		locations.setValue(locationList);
		return locations;
	}
	
	public Location getLocationById(int id) throws UnknownHostException, FileNotFoundException {
		for (int i=0; i<=locationList.size(); i++) {
			if (locationList.get(i).getId()==id) {
				return locationList.get(i);	
			}
		}
		return null;
	}
	
	public HistoricalLocations getHistoricalLocations(){
		HistoricalLocations historicalLocations = new HistoricalLocations();
		historicalLocations.setCount(historicalLocationList.size());
		historicalLocations.setValue(historicalLocationList);
		return historicalLocations;
	}
	
	public HistoricalLocation getHistoricalLocationById(int id){
		for (int i=0; i<=historicalLocationList.size(); i++) {
			if (historicalLocationList.get(i).getId()==id) {
				return historicalLocationList.get(i);	
			}
		}
		return null;
	}
	
	public Datastreams getDatastreams(){
		Datastreams datastreams = new Datastreams();
		datastreams.setCount(datastreamList.size());
		datastreams.setValue(datastreamList);
		return datastreams;
	}
	
	public Datastream getDatastreamById(int id){
		for (int i=0; i<=datastreamList.size(); i++) {
			if (datastreamList.get(i).getId()==id) {
				return datastreamList.get(i);	
			}
		}
		return null;
	}
	
	public Object getDatastreamByIdQueriedSelect(int id, String select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
			
			Datastream datastream = getDatastreamById(id);
			Map<String,Object> mapper = new HashMap<>();
			
					
				List<String> selectParams = Arrays.asList(select.split(","));			
				for (int i=0;i<selectParams.size();i++) {
					//Make sure the first character is small in the selectParam
					String selectStr = selectParams.get(i).substring(0, 1).toLowerCase()+selectParams.get(i).substring(1);
					Object value = PropertyUtils.getProperty(datastream, selectStr);
					
					Field field = Datastream.class.getDeclaredField(selectStr);
					if (field.isAnnotationPresent(JsonProperty.class)) {
						String annotationValue = field.getAnnotation(JsonProperty.class).value();
						mapper.put(annotationValue, value);
					}
					else {
						mapper.put(field.getName(), value);
					}
					//mapper.put(field.toString(), value);
				}
			
			
			return mapper;
			
		}
	
	public Object getDatastreamByIdQueriedExpanded(int id, String expanded) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		Datastream datastream = getDatastreamById(id);
		Map<String,Object> mapper = new HashMap<>();
		
		List<String> expandedParams = Arrays.asList(expanded.split(","));
		for (int i=0;i<expandedParams.size();i++) {
			Field[] fields = Datastream.class.getFields();
			switch(expandedParams.get(i).toUpperCase()) {
			case "OBSERVEDPROPERTY":
				ObservedProperty observedProperty = getObservedPropertyById(id);
				mapper.put("ObservedProperty", observedProperty);
				for (Field field:fields) {
					Object value = PropertyUtils.getProperty(datastream,field.getName());

					if(!field.getName().equalsIgnoreCase(expandedParams.get(i))) {
						if (field.isAnnotationPresent(JsonProperty.class)) {
							String annotationValue = field.getAnnotation(JsonProperty.class).value();	
							mapper.put(annotationValue, value);
						}
						else {
							mapper.put(field.getName(), value);
						}
					}
					
				}
					
				
			}
				
		}
		return mapper;
		
	}
	
	public Object getDatastreamByIdQueried(int id, String expanded, String select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		Map<String,Object> mapper = new HashMap<>();
		ObjectMapper oMapper = new ObjectMapper();
		
		
		Object obj1 = getDatastreamByIdQueriedExpanded(id,expanded);
		Object obj2 = getDatastreamByIdQueriedSelect(id,select);
		Map<Object, Object> map = oMapper.convertValue(obj1, Map.class);
		
		
		List<String> expandedParams = Arrays.asList(expanded.split(","));
		List<String> selectParams = Arrays.asList(select.split(","));	
		
		for (int i=0;i<selectParams.size();i++) {
			if (!map.get(selectParams.get(i)).equals(null)) {
				mapper.put(selectParams.get(i), map.get(selectParams.get(i)));
			}
		}
		
		
		return mapper;
		
	}
	
	public Sensors getSensors(){
		Sensors sensors = new Sensors();
		sensors.setCount(sensorList.size());
		sensors.setValue(sensorList);
		return sensors;
	}
	
	public Sensor getSensorById(int id){
		for (int i=0; i<=sensorList.size(); i++) {
			if (sensorList.get(i).getId()==id) {
				return sensorList.get(i);	
			}
		}
		return null;
	}
	
	public ObservedProperties getObservedProperties(){
		ObservedProperties observedProperties = new ObservedProperties();
		observedProperties.setCount(observedPropertyList.size());
		observedProperties.setValue(observedPropertyList);
		return observedProperties;
	}
	
	public ObservedProperty getObservedPropertyById(int id){
		for (int i=0; i<=observedPropertyList.size(); i++) {
			if (observedPropertyList.get(i).getId()==id) {
				return observedPropertyList.get(i);	
			}
		}
		return null;
	}
	
	public FeaturesOfInterest getFeaturesOfInterest(){
		FeaturesOfInterest featuresOfInterest = new FeaturesOfInterest();
		featuresOfInterest.setCount(featureOfInterestList.size());
		featuresOfInterest.setValue(featureOfInterestList);
		return featuresOfInterest;
	}
	
	public FeatureOfInterest getFeatureOfInterestById(int id){
		for (int i=0; i<=featureOfInterestList.size(); i++) {
			if (featureOfInterestList.get(i).getId()==id) {
				return featureOfInterestList.get(i);	
			}
		}
		return null;
	}
	
	public Observations getObservations() throws ParseException, IOException {
		Observations observations = new Observations();
		List<Observation> observationList = new ArrayList<>();
		int timeseriesId = timeseriesService.getTimeseriesById(dataSourceService.getAllDataSources().get(0).getId()).getId();
		AtomicInteger observationSeq = new AtomicInteger();
		List<org.tum.gis.interSensorService.observation.Observation> queriedObservations = observationService.getObservationList(timeseriesId);
		switch(timeseriesService.getTimeseriesById(timeseriesId).getObservationType().toUpperCase()){
			case "OM_MEASUREMENT":
				for(int i=0;i<queriedObservations.size();i++) {
					Observation observation = new Observation();
					int observationId = observationSeq.incrementAndGet();
					observation.setId(observationId);
					
					String observationUrl = rootUrl()+"Observations("+observation.getId()+")";
					observation.setSelfLink(observationUrl);
					observation.setPhenomenonTime(queriedObservations.get(i).getTime());
					observation.setResult(String.valueOf(queriedObservations.get(i).getValue()));
					observation.setDatastream(observationUrl+"/Datastreams");
					observation.setFeatureOfInterest(observationUrl+"/FeatureOfInterest");
					
					observationList.add(observation);
					
				}
				
				
		}
		
		observations.setCount(observationList.size());
		observations.setValue(observationList);
		return observations;
	}
	
	public Observations getObservations(String startTime, String endTime) throws ParseException, IOException, URISyntaxException {
		Observations observations = new Observations();
		List<Observation> observationList = new ArrayList<>();
		int timeseriesId = timeseriesService.getTimeseriesById(dataSourceService.getAllDataSources().get(0).getId()).getId();
		AtomicInteger observationSeq = new AtomicInteger();
		List<org.tum.gis.interSensorService.observation.Observation> queriedObservations = observationService.getObservationList(timeseriesId, startTime, endTime);
		switch(timeseriesService.getTimeseriesById(timeseriesId).getObservationType().toUpperCase()){
			case "OM_MEASUREMENT":
				for(int i=0;i<queriedObservations.size();i++) {
					Observation observation = new Observation();
					int observationId = observationSeq.incrementAndGet();
					observation.setId(observationId);
					
					String observationUrl = rootUrl()+"Observations("+observation.getId()+")";
					observation.setSelfLink(observationUrl);
					observation.setPhenomenonTime(queriedObservations.get(i).getTime());
					observation.setResult(String.valueOf(queriedObservations.get(i).getValue()));
					observation.setDatastream(observationUrl+"/Datastreams");
					observation.setFeatureOfInterest(observationUrl+"/FeatureOfInterest");
					
					observationList.add(observation);
					
				}
				
				
		}
		
		observations.setCount(observationList.size());
		observations.setValue(observationList);
		return observations;
	}
	
	public Object getObservationsQueriedSelect (String startTime, String endTime, String select) throws ParseException, IOException, URISyntaxException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		Observations observations = getObservations(startTime,endTime);
		Map<String,Object> observationMapper = new HashMap<>();
		
		List<Map<String,Object>> queriedObsList = new ArrayList<>();
		Object queriedObservations = queriedObsList;
		
		ObjectMapper oMapper = new ObjectMapper();
		//Map<Object, Object> map = oMapper.convertValue(queriedObs, Map.class);

		List<String> selectParams = Arrays.asList(select.split(","));	
				
		for(int i=0;i<observations.getCount();i++) {
			Observation queriedObs = observations.getValue().get(i);
			Map<String,Object> mapper = new HashMap<>();
			for (int j=0;j<selectParams.size();j++) {
				String selectStr = selectParams.get(j).substring(0, 1).toLowerCase()+selectParams.get(j).substring(1);
				Object value = PropertyUtils.getProperty(queriedObs, selectStr);
				Field field = Observation.class.getDeclaredField(selectStr);
				
				/*if (!map.get(selectParams.get(i)).equals(null)) {
					mapper.put(selectParams.get(i), map.get(selectParams.get(i)));
				}*/
				
				if (field.isAnnotationPresent(JsonProperty.class)) {
					String annotationValue = field.getAnnotation(JsonProperty.class).value();
					mapper.put(annotationValue, value);
					//System.out.println(mapper);
				}
				else {
					mapper.put(field.getName(), value);
					//System.out.println(mapper);
				}
				
			}
			queriedObsList.add(mapper);
			
			
			
		}
		observationMapper.put("@iot.count", observations.getCount());
		observationMapper.put("value", queriedObsList);
		
		return observationMapper;
				
				
				
		
	}
	
}
