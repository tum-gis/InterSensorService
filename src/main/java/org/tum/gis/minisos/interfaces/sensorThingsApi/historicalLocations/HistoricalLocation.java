package org.tum.gis.minisos.interfaces.sensorThingsApi.historicalLocations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricalLocation {

	@JsonProperty("@iot.id")
	public int id;
	@JsonProperty("@iot.selfLink")
	public String selfLink;
	public String time;
	@JsonProperty("Locations@iot.navigationLink")
	public String locations;
	@JsonProperty("Thing@iot.navigationLink")
	public String thing;
	
	public HistoricalLocation() {
		
	}
	
	public HistoricalLocation(int id, String selfLink, String time, String locations, String thing) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.time = time;
		this.locations = locations;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	
	
}
