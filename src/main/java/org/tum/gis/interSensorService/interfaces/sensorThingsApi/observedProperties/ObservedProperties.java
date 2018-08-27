package org.tum.gis.interSensorService.interfaces.sensorThingsApi.observedProperties;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObservedProperties {

	@JsonProperty("@iot.count")
	private int count;
	private List<ObservedProperty> value;
	
	public ObservedProperties() {
	
	}
	
	public ObservedProperties(int count, List<ObservedProperty> value) {
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
	public List<ObservedProperty> getValue() {
		return value;
	}
	public void setValue(List<ObservedProperty> value) {
		this.value = value;
	}
	
	
}
