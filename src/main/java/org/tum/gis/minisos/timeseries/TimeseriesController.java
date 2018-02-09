package org.tum.gis.minisos.timeseries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeseriesController {

	@Autowired
	private TimeseriesService timeseriesService;
	
	@RequestMapping("/timeseries")
	public List<Timeseries> getTimeseriesList(){
		return timeseriesService.getTimeseriesList();
	}
	
	@RequestMapping("/timeseries/{id}")
	public Timeseries getTimeseriesById(@PathVariable int id) {
		return timeseriesService.getTimeseriesById(id);
	}
	
	// /timeseries/1/observations
	// 
}
