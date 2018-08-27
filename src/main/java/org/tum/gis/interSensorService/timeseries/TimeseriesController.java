package org.tum.gis.interSensorService.timeseries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeseriesController {

	@Autowired
	private TimeseriesService timeseriesService;
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/timeseries", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Timeseries> getTimeseriesList(){
		return timeseriesService.getTimeseriesList();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/timeseries/{id}" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public Timeseries getTimeseriesById(@PathVariable int id) {
		return timeseriesService.getTimeseriesById(id);
	}
	
	// /timeseries/1/observations
	// 
}
