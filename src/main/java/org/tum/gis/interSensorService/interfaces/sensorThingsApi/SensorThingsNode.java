package org.tum.gis.interSensorService.interfaces.sensorThingsApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorThingsNode {

	
	private String name;
	private String url;
	
	public SensorThingsNode() {
		
	}
	
	public SensorThingsNode(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
