package org.tum.gis.minisos.interfaces.sensorThingsApi.sensors;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensors {

	@JsonProperty("@iot.count")
	private int count;
	private List<Sensor> value;
	
	public Sensors() {

	}
	
	public Sensors(int count, List<Sensor> value) {
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
	public List<Sensor> getValue() {
		return value;
	}
	public void setValue(List<Sensor> value) {
		this.value = value;
	}
	
	
}
