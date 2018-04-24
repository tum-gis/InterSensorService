package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetObservationController {

	@Autowired
	private GetObservationService getObservationService;	
	@RequestMapping(value = "/ogc-sos-webapp/service", produces = {MediaType.APPLICATION_XML_VALUE} )	
	public GetObservationResponse getObservationResponse(@RequestParam (value = "service") String service,
														 @RequestParam (value = "version") String version,
														 @RequestParam (value = "request") String request,
														 @RequestParam (value = "temporalFilter") String temporalFilter
														) throws IOException, ParseException, URISyntaxException {
		
		//if (service == "SOS" && version == "2.0.0" && request == "GetObservation") {
			String[] phenomenonTime = temporalFilter.split(",");
			
			String[] splitStr = phenomenonTime[1].split("/");
			String startTime = splitStr[0];
			String endTime = splitStr[1];
			return getObservationService.getObservationResponse(1, startTime, endTime);
		//}
		//return null;	
	}
	
	
	
	
}
