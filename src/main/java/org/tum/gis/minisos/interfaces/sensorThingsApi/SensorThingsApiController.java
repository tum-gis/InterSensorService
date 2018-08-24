package org.tum.gis.minisos.interfaces.sensorThingsApi;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tum.gis.minisos.interfaces.sensorThingsApi.things.Thing;

@RestController
public class SensorThingsApiController {

	@Autowired
	private SensorThingsApiService sensorThingsApiService;
	
	@CrossOrigin()
	@RequestMapping(value = "/OGCSensorThingsApi/v1.0", produces = {MediaType.APPLICATION_JSON_VALUE})
	public SensorThingsApi getSensorThingsApi() throws UnknownHostException, FileNotFoundException{
		
		SensorThingsApi sensorThingsApi = sensorThingsApiService.getSensorThingsApi();
		return sensorThingsApi;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/OGCSensorThingsApi/v1.0/Things({id})", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Thing getThingById(@PathVariable int id) throws UnknownHostException, FileNotFoundException {
		Thing thing = sensorThingsApiService.getThingById(id);
		return thing;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/OGCSensorThingsApi/v1.0/Things({id})", params = {"$select"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object getThingByIdQueried(@PathVariable int id,
									 @RequestParam (value = "$select", required=false) Optional<String> select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		
		
		Object queriedResponse = sensorThingsApiService.getThingByIdQueried(id,select);
		return queriedResponse;
	}
}
