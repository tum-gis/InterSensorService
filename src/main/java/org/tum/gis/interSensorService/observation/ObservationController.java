/*
 * InterSensor Service
 * http://www.intersensorservice.org/
 * 
 * Copyright 2018
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 * 
 * The InterSensor Service has been developed by
 * Kanishk Chaturvedi and Thomas H. Kolbe
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.tum.gis.interSensorService.observation;


import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tum.gis.interSensorService.interfaces.Interface;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation.GetObservationResponse;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.ListObservation52n;


@RestController
public class ObservationController {

	// timeseries/id/observations
	// observationService.getObservation(id);
	
	@Autowired
	private ObservationService observationService;
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/timeseries/{id}/observations" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Observation> getObservationList(@PathVariable int id) throws IOException, ParseException{
		return observationService.getObservationList(id);
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/timeseries/{id}/observations", params = {"start", "end"} , produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Observation> getObservationList(@PathVariable int id,
												@RequestParam (value = "start") String startTime,
												@RequestParam (value = "end") String endTime) throws ParseException, IOException, URISyntaxException{
		return observationService.getObservationList(id,startTime,endTime);
	}
	
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/timeseries/{id}/observations", params = {"start", "end", "format"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ListObservation52n getObservationList(@PathVariable int id,
												@RequestParam (value = "start") String startTime,
												@RequestParam (value = "end") String endTime,
												@RequestParam (value = "format") String format) throws ParseException, IOException, URISyntaxException{
		//find a way to take only Rest52n as input to the value of format
		//then, create multiple functions with same name returning different types
		return observationService.getObservationList(id,startTime,endTime,format);
	}
	
	/*@RequestMapping(value = "/timeseries/{id}/observations", params = {"start", "end", "format"} , produces = {MediaType.APPLICATION_XML_VALUE})
	public GetObservationResponse getObservationList(@PathVariable int id,
												@RequestParam (value = "start") String startTime,
												@RequestParam (value = "end") String endTime,
												@RequestParam (value = "format") String format) throws ParseException, IOException{
		//find a way to take only Rest52n as input to the value of format
		//then, create multiple functions with same name returning different types
		return observationService.getObservationList(id,startTime,endTime,format);
	}*/
	
	
	
}
