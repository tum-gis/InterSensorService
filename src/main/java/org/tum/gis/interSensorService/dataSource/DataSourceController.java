package org.tum.gis.interSensorService.dataSource;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tum.gis.interSensorService.initializer.LinkNavigator;
import org.tum.gis.interSensorService.util.SpringHost;

@RestController
public class DataSourceController {

	@Autowired
	private DataSourceService dataSourceService;
	
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<LinkNavigator> getAllLinks() throws UnknownHostException, FileNotFoundException{
		
		String rootUrl = "http://"+SpringHost.getHostAddress()+":"+SpringHost.getPort();
		LinkNavigator link1 = new LinkNavigator("dataSources",rootUrl+"/inter-sensor-service/datasources","Retrieve details of established data sources");
		LinkNavigator link2 = new LinkNavigator("timeseries",rootUrl+"/inter-sensor-service/timeseries","Retrieve metadata of timeseries from the data source");
		LinkNavigator link3 = new LinkNavigator("observations",rootUrl+"/inter-sensor-service/timeseries/1/observations?start=2018-08-05T00:00:00&end=2018-08-05T05:00:00","Retrieve details of observations from selected timeseries. Timeseries ID and temporal filters can be changed as per requirements.");
		LinkNavigator link4 = new LinkNavigator("52n-rest-api",rootUrl+"/52n-rest-api","Retrieve root interface for the 52°North RESTful Timeseries API. This root link can be used to query and visualize timeseries data on OGC SOS compliant applications such as Helgoland client.");
		LinkNavigator link5 = new LinkNavigator("OGCSensorThingsAPI",rootUrl+"/OGCSensorThingsApi/v1.0","Retrieve root interface for the OGC SensorThings API. This root link can be used to query and visualize timeseries data on OGC SensorThings API compliant applications such as SensorThings HCDT Library.");
		LinkNavigator link6 = new LinkNavigator("ogc-sos-webapp",rootUrl+"/ogc-sos-webapp/service?service=SOS&version=2.0.0&request=GetObservation&temporalFilter=om:phenomenonTime,2018-08-05T00:00:00/2018-08-05T05:00:00","Retrieve OGC Sensor Observation Service GetObservation response encoded in OGC Observations & Measurements. Such responses can be used to query and visualize timeseries data on OGC SOS compliant applications.");
		
		List<LinkNavigator> list = new ArrayList<>(Arrays.asList(link1,link2,link3,link4,link5,link6));
		return list;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/datasources", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<DataSource> getAllDataSources(){
		return dataSourceService.getAllDataSources();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/datasources/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public DataSource getDataSource(@PathVariable int id) {
		return dataSourceService.getDataSource(id);
	}
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.DELETE, value="/inter-sensor-service/datasources/{id}")
		public void deleteDataSource(@PathVariable int id) {
			dataSourceService.deleteDataSource(id);
		}
	}
	
	/*@RequestMapping(method=RequestMethod.POST, value="/datasources")
	public void addDataSource(@RequestBody DataSource dataSource) {
		dataSourceService.addDataSource(dataSource);
	}*/

