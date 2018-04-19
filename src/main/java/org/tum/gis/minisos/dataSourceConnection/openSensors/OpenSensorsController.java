package org.tum.gis.minisos.dataSourceConnection.openSensors;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OpenSensorsController {

	@Autowired
	private OpenSensorsService openSensorsService;
	
	@RequestMapping(method=RequestMethod.POST, value="/datasourcesOpenSensors")
	public void addDataSource(@RequestBody OpenSensorsConnection openSensorsConnection) throws URISyntaxException {
		openSensorsService.addDataSource(openSensorsConnection);
	}
}
