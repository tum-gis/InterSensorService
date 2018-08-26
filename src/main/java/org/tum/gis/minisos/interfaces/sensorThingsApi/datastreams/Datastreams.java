package org.tum.gis.minisos.interfaces.sensorThingsApi.datastreams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datastreams {

	@JsonProperty("@iot.count")
	private int count;
	private List<Datastream> value;
	
	public Datastreams() {
		
	}
	
	public Datastreams(int count, List<Datastream> value) {
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
	public List<Datastream> getValue() {
		return value;
	}
	public void setValue(List<Datastream> value) {
		this.value = value;
	}
	
	
}
