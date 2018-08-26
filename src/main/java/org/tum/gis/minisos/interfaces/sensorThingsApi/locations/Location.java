package org.tum.gis.minisos.interfaces.sensorThingsApi.locations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@JsonProperty("@iot.id")
	public int id;
	
	@JsonProperty("@iot.selfLink")
	public String selfLink;
	
	public String description;
	public String name;
	public String encodingType;
	public Coordinates location;
	public String type;
	
	@JsonProperty("Things@iot.navigationLink")
	private String things;
	
	@JsonProperty("HistoricalLocations@iot.navigationLink")
	private String historicalLocations;
	
	
	public Location() {
		
	}
	
	public Location(int id, String selfLink, String description, String name, String encodingType, Coordinates location,
			String type, String things, String historicalLocations) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.description = description;
		this.name = name;
		this.encodingType = encodingType;
		this.location = location;
		this.type = type;
		this.things = things;
		this.historicalLocations = historicalLocations;
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
	public Coordinates getLocation() {
		return location;
	}
	public void setLocation(Coordinates location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getThings() {
		return things;
	}
	public void setThings(String things) {
		this.things = things;
	}
	public String getHistoricalLocations() {
		return historicalLocations;
	}
	public void setHistoricalLocations(String historicalLocations) {
		this.historicalLocations = historicalLocations;
	}
	
	
	
	
}
