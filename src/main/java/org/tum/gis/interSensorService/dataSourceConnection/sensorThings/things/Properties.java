package org.tum.gis.interSensorService.dataSourceConnection.sensorThings.things;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {

	
	private String displayName;

	public Properties() {
		
	}
	
	public Properties(String displayName) {
		super();
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
