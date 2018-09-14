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
