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

public class DescribeSensorResponse {

	private String procedureDescriptionFormat = "http://www.opengis.net/sensorML/1.0.1";
	private Description description = new Description();
	public DescribeSensorResponse() {
		
	}
	
	public DescribeSensorResponse(String procedureDescriptionFormat, Description description) {
		super();
		this.procedureDescriptionFormat = procedureDescriptionFormat;
		this.description = description;
	}
	public String getProcedureDescriptionFormat() {
		return procedureDescriptionFormat;
	}
	public void setProcedureDescriptionFormat(String procedureDescriptionFormat) {
		this.procedureDescriptionFormat = procedureDescriptionFormat;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	
	
}
