package org.tum.gis.minisos.dataSourceConnection.sensorThings.datastreams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Datastreams {
	private String description;
	private String name;
	private String observationType;

	@JsonProperty("unitOfMeasurement")
	private UnitOfMeasurement unitOfMeasurement;

	
	public Datastreams() {
		
	}
	
	public Datastreams(String description, String name, String observationType, UnitOfMeasurement unitOfMeasurement) {
		super();
		this.description = description;
		this.name = name;
		this.observationType = observationType;
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservationType() {
		return observationType;
	}

	public void setObservationType(String observationType) {
		this.observationType = observationType;
	}

	public UnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}
	
	

}
