package org.tum.gis.minisos.interfaces.sensorThingsApi;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.interfaces.sensorThingsApi.locations.Location;
import org.tum.gis.minisos.interfaces.sensorThingsApi.things.Thing;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.SpringHost;

import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class SensorThingsApiService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
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
	
	public Thing getThingById(int id) throws UnknownHostException, FileNotFoundException {
		Thing thing = new Thing();
		
		thing.setId(dataSourceService.getDataSource(id).getId());
		String thingUrl = rootUrl()+"Things("+thing.getId()+")";
		
		thing.setSelfLink(thingUrl);
		thing.setDescription(dataSourceService.getDataSource(id).getDataSourceConnection().getDescription());
		thing.setName(dataSourceService.getDataSource(id).getDataSourceConnection().getName());
		thing.setDatastreams(thingUrl+"/Datastreams");
		thing.setHistoricalLocations(thingUrl+"/HistoricalLocations");
		thing.setLocations(thingUrl+"/Locations");
		return thing;
	}
	
	public Object getThingByIdQueried(int id, Optional<String> select) throws UnknownHostException, FileNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		
		Thing thing = getThingById(id);
		Map<String,Object> mapper = new HashMap<>();
		
		if (select.isPresent()) {			
			List<String> selectParams = Arrays.asList(select.get().split(","));			
			for (int i=0;i<selectParams.size();i++) {
				Object value = PropertyUtils.getProperty(thing, selectParams.get(i));
				Field field = Thing.class.getDeclaredField(selectParams.get(i));
				if (field.isAnnotationPresent(JsonProperty.class)) {
					String annotationValue = field.getAnnotation(JsonProperty.class).value();
					mapper.put(annotationValue, value);
				}
				else {
					mapper.put(field.getName(), value);
				}
				//mapper.put(field.toString(), value);
			}
		}
		
		return mapper;
		
	}
	
	public Location getLocationById(int id) throws UnknownHostException, FileNotFoundException {
		//Thing thing = new Thing();
		Location location = new Location();
		location.setId(dataSourceService.getDataSource(id).getId());
		String locationUrl = rootUrl()+"Locations("+location.getId()+")";
		
		location.setSelfLink(locationUrl);
		return location;
	}
	
}
