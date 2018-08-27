package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DescribeSensorController {

	@Autowired
	public DescribeSensorService describeSensorService;
	
	@RequestMapping(value = "/ogc-sos-webapp/service", params = {"service","version","request","procedureDescriptionFormat"}, produces = {MediaType.APPLICATION_XML_VALUE} )
	public DescribeSensorResponse getDescribeSensorResponse(@RequestParam (value = "service") String service,
			 												@RequestParam (value = "version") String version,
			 												@RequestParam (value = "request") String request,
			 												@RequestParam (value = "procedureDescriptionFormat") String procedureDescriptionFormat) {
		return describeSensorService.getDescribeSensorResponse();
	}
}
