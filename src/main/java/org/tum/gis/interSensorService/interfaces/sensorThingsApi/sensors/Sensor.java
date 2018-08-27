package org.tum.gis.interSensorService.interfaces.sensorThingsApi.sensors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensor {

	@JsonProperty("@iot.id")
	public int id;
	@JsonProperty("@iot.selfLink")
	public String selfLink;
	public String description;
	public String name;
	public String encodingType;
	public String metadata;
	@JsonProperty("Datastreams@iot.navigationLink")
	public String datastreams;
	
	public Sensor() {
		
	}
	
	public Sensor(int id, String selfLink, String description, String name, String encodingType, String metadata,
			String datastreams) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.description = description;
		this.name = name;
		this.encodingType = encodingType;
		this.metadata = metadata;
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
	public String getEncodingType() {
		return encodingType;
	}
	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public String getDatastreams() {
		return datastreams;
	}
	public void setDatastreams(String datastreams) {
		this.datastreams = datastreams;
	}
	
	
	
}
