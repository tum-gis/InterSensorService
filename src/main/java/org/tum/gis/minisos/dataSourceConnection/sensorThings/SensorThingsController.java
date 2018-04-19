package org.tum.gis.minisos.dataSourceConnection.sensorThings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorThingsController {

	@Autowired
	private SensorThingsService sensorThingsService;
	
	@RequestMapping(method=RequestMethod.POST, value="/datasourcesSensorThings")
	public void addDataSource(@RequestBody SensorThingsConnection sensorThingsConnection) {
		sensorThingsService.addDataSource(sensorThingsConnection);
	}
}
