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
	@RequestMapping(value = "/api/getObservation", params = {"phenomenonTime"}, produces = {MediaType.APPLICATION_XML_VALUE} )	
	public GetObservationResponse getObservationResponse(@RequestParam (value = "phenomenonTime") String phenomenonTime
														) throws IOException, ParseException, URISyntaxException {
		
		String[] splitStr = phenomenonTime.split("/");
		String startTime = splitStr[0];
		String endTime = splitStr[1];
		return getObservationService.getObservationResponse(1, startTime, endTime);
	}
	
	
	/*public String abc() {
	System.out.println("started");
	String s = "abc";
	return s;
}*/
}
