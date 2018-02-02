package org.tum.gis.minisos.timeseries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeseriesController {

	@Autowired
	private TimeseriesService timeSeriesService;
	
	@RequestMapping("/timeseries")
	public List<Timeseries> getTimeseriesList(){
		return timeSeriesService.getTimeseriesList();
	}
	
	// /timeseries/1/observations
	// 
}
