package org.tum.gis.minisos.interfaces.sensorThingsApi.datastreams;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datastream {

	@JsonProperty("@iot.id")
	public int id;
	@JsonProperty("@iot.selfLink")
	public String selfLink;
	public String description;
	public String name;
	public String observationType;
	public UnitOfMeasurement unitOfMeasurement;
	@JsonProperty("Observations@iot.navigationLink")
	public String observations;
	@JsonProperty("ObservedProperty@iot.navigationLink")
	public String observedProperty;
	@JsonProperty("Sensor@iot.navigationLink")
	public String sensor;
	@JsonProperty("Thing@iot.navigationLink")
	public String thing;
	
	public Datastream() {
		
	}
	
	public Datastream(int id, String selfLink, String description, String name, String observationType,
			UnitOfMeasurement unitOfMeasurment, String observations, String observedProperty, String sensor,
			String thing) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.description = description;
		this.name = name;
		this.observationType = observationType;
		this.unitOfMeasurement = unitOfMeasurment;
		this.observations = observations;
		this.observedProperty = observedProperty;
		this.sensor = sensor;
		this.thing = thing;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSelfLink() {
		return selfLink;
	}
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
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
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public String getObservedProperty() {
		return observedProperty;
	}
	public void setObservedProperty(String observedProperty) {
		this.observedProperty = observedProperty;
	}
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	
	
	
}
