package org.tum.gis.interSensorService.interfaces.sensorThingsApi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.datastreams.Datastream;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.datastreams.Datastreams;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.featuresOfInterest.FeatureOfInterest;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.featuresOfInterest.FeaturesOfInterest;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.historicalLocations.HistoricalLocation;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.historicalLocations.HistoricalLocations;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.locations.Location;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.locations.Locations;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.observations.Observations;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.observedProperties.ObservedProperties;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.observedProperties.ObservedProperty;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.sensors.Sensor;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.sensors.Sensors;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.things.Thing;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.things.Things;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/OGCSensorThingsApi/v1.0")
public class SensorThingsApiController {

	@Autowired
	private SensorThingsApiService sensorThingsApiService;
	
	@CrossOrigin()
	@RequestMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
	public SensorThingsApi getSensorThingsApi() throws UnknownHostException, FileNotFoundException{
		
		SensorThingsApi sensorThingsApi = sensorThingsApiService.getSensorThingsApi();
		return sensorThingsApi;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/Things","/Locations({id})/Things"}, 
					produces = {MediaType.APPLICATION_JSON_VALUE})
	public Things getThings() throws UnknownHostException, FileNotFoundException {
		Things things = sensorThingsApiService.getThings();
		return things;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Things({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Thing getThingById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		Thing thing = sensorThingsApiService.getThingById(id);
		return thing;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Things({id})", params = {"$select"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getThingByIdQueriedSelect(@PathVariable int id,
									 @RequestParam (value = "$select", required=false) String select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		
		
		Object queriedResponse = sensorThingsApiService.getThingByIdQueriedSelect(id,select);
		return queriedResponse;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Things({id})", params = {"$expanded"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getThingByIdQueriedExpanded(@PathVariable int id,
									 @RequestParam (value = "$expanded") String expanded) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		
		
		Object queriedResponse = sensorThingsApiService.getThingByIdQueriedExpanded(id,expanded);
		return queriedResponse;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Things({id})", params = {"$expanded","$select"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getThingByIdQueriedExpanded(@PathVariable int id,
									 @RequestParam (value = "$expanded") String expanded,
									 @RequestParam (value = "$select") String select) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException, JsonProcessingException, IOException {
		
		
		Object queriedResponse = sensorThingsApiService.getThingByIdQueried(id,expanded,select);
		return queriedResponse;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/Locations","/Things({id})/Locations"}, 
							produces = {MediaType.APPLICATION_JSON_VALUE})
	public Locations getLocations() throws UnknownHostException, FileNotFoundException {
		Locations locations = sensorThingsApiService.getLocations();
		return locations;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Locations({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Location getLocationById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		Location location = sensorThingsApiService.getLocationById(id);
		return location;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/HistoricalLocations","/Things({id})/HistoricalLocations"}, 
							produces = {MediaType.APPLICATION_JSON_VALUE})
	public HistoricalLocations getHistoricalLocations() throws UnknownHostException, FileNotFoundException {
		HistoricalLocations historicalLocations = sensorThingsApiService.getHistoricalLocations();
		return historicalLocations;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/HistoricalLocations({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public HistoricalLocation getHistoricalLocationById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		HistoricalLocation historicalLocation = sensorThingsApiService.getHistoricalLocationById(id);
		return historicalLocation;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/Datastreams","/Things({id})/Datastreams"}, 
							produces = {MediaType.APPLICATION_JSON_VALUE})
	public Datastreams getDatastreams() throws UnknownHostException, FileNotFoundException {
		Datastreams datastreams = sensorThingsApiService.getDatastreams();
		return datastreams;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Datastreams({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Datastream getDatastreamById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		Datastream datastream = sensorThingsApiService.getDatastreamById(id);
		return datastream;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Datastreams({id})", params = {"$select"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getDatastreamByIdQueriedSelect(@PathVariable int id,
									 @RequestParam (value = "$select", required=false) String select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		
		
		Object queriedResponse = sensorThingsApiService.getDatastreamByIdQueriedSelect(id, select);
		return queriedResponse;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Datastreams({id})", params = {"$expand"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getDatastreamByIdQueriedExpanded(@PathVariable int id,
									 @RequestParam (value = "$expand") String expanded) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		
		
		Object queriedResponse = sensorThingsApiService.getDatastreamByIdQueriedExpanded(id, expanded);
		return queriedResponse;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Datastreams({id})", params = {"$expand","$select"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getDatastreamByIdQueriedExpanded(@PathVariable int id,
									 @RequestParam (value = "$expand") String expanded,
									 @RequestParam (value = "$select") String select) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException, JsonProcessingException, IOException {
		
		
		Object queriedResponse = sensorThingsApiService.getDatastreamByIdQueried(id, expanded, select);
		return queriedResponse;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/Sensors"}, 
							produces = {MediaType.APPLICATION_JSON_VALUE})
	public Sensors getSensors() throws UnknownHostException, FileNotFoundException {
		Sensors sensors = sensorThingsApiService.getSensors();
		return sensors;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Sensors({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Sensor getSensorById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		Sensor sensor = sensorThingsApiService.getSensorById(id);
		return sensor;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/ObservedProperties"}, 
							produces = {MediaType.APPLICATION_JSON_VALUE})
	public ObservedProperties getObservedProperties() throws UnknownHostException, FileNotFoundException {
		ObservedProperties observedProperties = sensorThingsApiService.getObservedProperties();
		return observedProperties;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/ObservedProperties({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ObservedProperty getObservedPropertyById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		ObservedProperty observedProperty = sensorThingsApiService.getObservedPropertyById(id);
		return observedProperty;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/FeaturesOfInterest"}, 
							produces = {MediaType.APPLICATION_JSON_VALUE})
	public FeaturesOfInterest getFeaturesOfInterest() throws UnknownHostException, FileNotFoundException {
		FeaturesOfInterest featuresOfInterest = sensorThingsApiService.getFeaturesOfInterest();
		return featuresOfInterest;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/FeaturesOfInterest({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public FeatureOfInterest getFeatureOfInterestById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		FeatureOfInterest featureOfInterest = sensorThingsApiService.getFeatureOfInterestById(id);
		return featureOfInterest;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/Observations", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Observations getObservations() throws ParseException, IOException {
		Observations observations = sensorThingsApiService.getObservations();
		return observations;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/Observations","/Datastreams({id})/Observations"}, params = {"$filter"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Observations getObservations(
									 @RequestParam (value = "$filter") String filter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException, ParseException, IOException, URISyntaxException {
		
		String removeUnwantedChars = filter.replace("%20"," ");
		String removeUnwantedChars2 = removeUnwantedChars.replace("%27", "'");
		String modifiedFilter = removeUnwantedChars2.replace("'", "");
		List<String> filterParams = Arrays.asList(modifiedFilter.split(" "));
		int startTimeIndex=0;
		int endTimeIndex=0;
		
		if(filterParams.contains("gt")) {
			 startTimeIndex = filterParams.indexOf("gt")+1;
		}else if(filterParams.contains("ge")) {
			startTimeIndex = filterParams.indexOf("ge")+1;
		}
		
		if(filterParams.contains("lt")) {
			 endTimeIndex = filterParams.indexOf("lt")+1;
		}else if(filterParams.contains("le")) {
			endTimeIndex = filterParams.indexOf("le")+1;
		}
		
		String startTime = filterParams.get(startTimeIndex);
		String endTime = filterParams.get(endTimeIndex);
		
		
		Observations observations = sensorThingsApiService.getObservations(startTime,endTime);
		return observations;
	}
	
	@CrossOrigin()
	@RequestMapping(value = {"/Observations","/Datastreams({id})/Observations"}, params = {"$filter","$select"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getObservations(
									 @RequestParam (value = "$filter") String filter,
									 @RequestParam (value = "$select") String select) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException, ParseException, IOException, URISyntaxException {
		
		String removeUnwantedChars = filter.replace("%20"," ");
		String removeUnwantedChars2 = removeUnwantedChars.replace("%27", "'");
		String modifiedFilter = removeUnwantedChars2.replace("'", "");
		List<String> filterParams = Arrays.asList(modifiedFilter.split(" "));
		int startTimeIndex=0;
		int endTimeIndex=0;
		
		if(filterParams.contains("gt")) {
			 startTimeIndex = filterParams.indexOf("gt")+1;
		}else if(filterParams.contains("ge")) {
			startTimeIndex = filterParams.indexOf("ge")+1;
		}
		
		if(filterParams.contains("lt")) {
			 endTimeIndex = filterParams.indexOf("lt")+1;
		}else if(filterParams.contains("le")) {
			endTimeIndex = filterParams.indexOf("le")+1;
		}
		
		String startTime = filterParams.get(startTimeIndex);
		String endTime = filterParams.get(endTimeIndex);
		
		
		Object observations = sensorThingsApiService.getObservationsQueriedSelect(startTime, endTime, select);
		return observations;
	}
}
