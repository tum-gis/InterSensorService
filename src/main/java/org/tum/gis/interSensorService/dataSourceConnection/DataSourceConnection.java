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

package org.tum.gis.interSensorService.dataSourceConnection;

public class DataSourceConnection {
	
	private String name;
	private String description;
	private String connectionType;
	private String observationProperty;
	private String observationType;
	private String unitOfMeasure;
	
	public DataSourceConnection() {
		
	}
	
	public DataSourceConnection(int id, String name, String description, String connectionType, String observationProperty, String observationType,
			String unitOfMeasure) {
		super();
		//this.id = id;
		this.name = name;
		this.description = description;
		this.connectionType = connectionType;
		this.observationProperty = observationProperty;
		this.observationType = observationType;
		this.unitOfMeasure = unitOfMeasure;
	}


	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getConnectionType() {
		return connectionType;
	}


	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	
	


	public String getObservationProperty() {
		return observationProperty;
	}

	public void setObservationProperty(String observationProperty) {
		this.observationProperty = observationProperty;
	}

	public String getObservationType() {
		return observationType;
	}


	public void setObservationType(String observationType) {
		this.observationType = observationType;
	}


	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}


	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	
	

}
