package org.tum.gis.minisos.dataSourceConnection.sensorThings.locations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@JsonProperty("coordinates")
	private List<Double> coordinates;
	
	private String type;

	public Location() {
		
	}
	
	

	public Location(List<Double> coordinates, String type) {
		super();
		this.coordinates = coordinates;
		this.type = type;
	}



	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
