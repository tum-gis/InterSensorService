package org.tum.gis.minisos.dataSource.sensorThings.observations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Observations {

	@JsonProperty("@iot.count")
	private int count;
	
	@JsonProperty("value")
	private List<Value> value;

	public Observations() {
		
	}
	
	public Observations(int count, List<Value> value) {
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

	public List<Value> getValue() {
		return value;
	}

	public void setValue(List<Value> value) {
		this.value = value;
	}
	
	
}
