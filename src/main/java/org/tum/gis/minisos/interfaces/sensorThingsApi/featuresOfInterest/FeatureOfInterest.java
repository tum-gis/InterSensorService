package org.tum.gis.minisos.interfaces.sensorThingsApi.featuresOfInterest;

import org.tum.gis.minisos.interfaces.sensorThingsApi.locations.Coordinates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureOfInterest {

	@JsonProperty("@iot.id")
	public int id;
	
	@JsonProperty("@iot.selfLink")
	public String selfLink;
	
	public String description;
	public String name;
	public String encodingType;
	public Coordinates feature;
	public String type;
	
	@JsonProperty("Observations@iot.navigationLink")
	public String observations;

	public FeatureOfInterest() {
		
	}
	
	public FeatureOfInterest(int id, String selfLink, String description, String name, String encodingType,
			Coordinates feature, String type, String observations) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.description = description;
		this.name = name;
		this.encodingType = encodingType;
		this.feature = feature;
		this.type = type;
		this.observations = observations;
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

	public String getEncodingType() {
		return encodingType;
	}

	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}

	public Coordinates getFeature() {
		return feature;
	}

	public void setFeature(Coordinates feature) {
		this.feature = feature;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	
}
