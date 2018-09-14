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

package org.tum.gis.interSensorService.timeseries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeseriesController {

	@Autowired
	private TimeseriesService timeseriesService;
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/timeseries", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Timeseries> getTimeseriesList(){
		return timeseriesService.getTimeseriesList();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/inter-sensor-service/timeseries/{id}" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public Timeseries getTimeseriesById(@PathVariable int id) {
		return timeseriesService.getTimeseriesById(id);
	}
	
	// /timeseries/1/observations
	// 
}
