package org.tum.gis.interSensorService.interfaces.sensorThingsApi.observations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Observations {

	@JsonProperty("@iot.count")
	private int count;
	private List<Observation> value;
	
	public Observations() {
		
	}
	
	public Observations(int count, List<Observation> value) {
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
	public List<Observation> getValue() {
		return value;
	}
	public void setValue(List<Observation> value) {
		this.value = value;
	}
	
	
}
