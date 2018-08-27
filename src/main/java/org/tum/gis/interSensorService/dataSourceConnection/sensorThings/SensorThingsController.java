package org.tum.gis.interSensorService.dataSourceConnection.sensorThings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorThingsController {

	@Autowired
	private SensorThingsService sensorThingsService;
	
	@RequestMapping(method=RequestMethod.POST, value="/sensorThings")
	public void addDataSource(@RequestBody SensorThingsConnection sensorThingsConnection) {
		sensorThingsService.addDataSource(sensorThingsConnection);
	}
}
