package org.tum.gis.minisos.dataSourceConnection.twitter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geo {

	@JsonProperty("type")
	private String type;
	@JsonProperty("cooridnates")
	private List<Double> coordinates = new ArrayList<>();
	
	public Geo(){
		
	}
	
	public Geo(String type, List<Double> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
