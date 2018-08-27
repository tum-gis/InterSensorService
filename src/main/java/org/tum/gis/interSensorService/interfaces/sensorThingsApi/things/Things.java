package org.tum.gis.interSensorService.interfaces.sensorThingsApi.things;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Things {

	@JsonProperty("@iot.count")
	private int count;
	
	private List<Thing> value;
	
	public Things(){
		
	}
	
	public Things(int count, List<Thing> value) {
		super();
		this.count = count;
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Thing> getValue() {
		return value;
	}
	public void setValue(List<Thing> value) {
		this.value = value;
	}
	
	
}
