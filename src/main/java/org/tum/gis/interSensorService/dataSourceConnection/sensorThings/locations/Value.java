package org.tum.gis.interSensorService.dataSourceConnection.sensorThings.locations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {

	private String description;
	private String name;
	private String encodingType;
	@JsonProperty("location")
	private Location location;

	public Value() {
		
	}
	
	
	public Value(String description, String name, String encodingType, Location location) {
		super();
		this.description = description;
		this.name = name;
		this.encodingType = encodingType;
		this.location = location;
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


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
}
