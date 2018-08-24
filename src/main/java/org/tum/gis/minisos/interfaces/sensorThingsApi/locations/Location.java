package org.tum.gis.minisos.interfaces.sensorThingsApi.locations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@JsonProperty("@iot.id")
	private int id;
	
	@JsonProperty("@iot.selfLink")
	private String selfLink;
	
	private String description;
	private String name;
	private String encodingType;
	private Coordinates location;
	private String type;
	
	@JsonProperty("HistoricalLocations@iot.navigationLink")
	private String Things;
	
	@JsonProperty("Locations@iot.navigationLink")
	private String HistoricalLocations;
	
	
	public Location() {
		
	}
	
	public Location(int id, String selfLink, String description, String name, String encodingType, Coordinates location,
			String type, String Things, String HistoricalLocations) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.description = description;
		this.name = name;
		this.encodingType = encodingType;
		this.location = location;
		this.type = type;
		this.Things = Things;
		this.HistoricalLocations = HistoricalLocations;
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
		return Things;
	}
	public void setThings(String things) {
		Things = things;
	}
	public String getHistoricalLocations() {
		return HistoricalLocations;
	}
	public void setHistoricalLocations(String historicalLocations) {
		HistoricalLocations = historicalLocations;
	}
	
	
	
	
}
