package org.tum.gis.minisos.interfaces.sensorThingsApi.observedProperties;

import org.tum.gis.minisos.interfaces.sensorThingsApi.datastreams.UnitOfMeasurement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObservedProperty {

	@JsonProperty("@iot.id")
	public int id;
	@JsonProperty("@iot.selfLink")
	public String selfLink;
	public String description;
	public String name;
	public String definition;
	
	@JsonProperty("Datastreams@iot.navigationLink")
	public String datastreams;

	public ObservedProperty() {
		
	}
	
	public ObservedProperty(int id, String selfLink, String description, String name, String definition,
			String datastreams) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.description = description;
		this.name = name;
		this.definition = definition;
		this.datastreams = datastreams;
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

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getDatastreams() {
		return datastreams;
	}

	public void setDatastreams(String datastreams) {
		this.datastreams = datastreams;
	}
	
	
}
