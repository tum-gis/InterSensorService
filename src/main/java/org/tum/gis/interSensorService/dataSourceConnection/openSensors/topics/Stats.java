package org.tum.gis.interSensorService.dataSourceConnection.openSensors.topics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

	@JsonProperty("last-location")
	private Location location;

	public Stats() {
		
	}
	
	public Stats(Location location) {
		super();
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
