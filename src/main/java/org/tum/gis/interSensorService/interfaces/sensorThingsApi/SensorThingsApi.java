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

package org.tum.gis.interSensorService.interfaces.sensorThingsApi;

import java.util.List;

public class SensorThingsApi {

	private List<SensorThingsNode> value;

	public SensorThingsApi() {
		
	}
	
	public SensorThingsApi(List<SensorThingsNode> value) {
		super();
		this.value = value;
	}

	public List<SensorThingsNode> getValue() {
		return value;
	}

	public void setValue(List<SensorThingsNode> value) {
		this.value = value;
	}
	
	
	
	
}
