package org.tum.gis.minisos.dataSource.sensorThings.locations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Locations {
	@JsonProperty("value")
	private List<Value> value;

	public Locations() {
		
	}

	public Locations(List<Value> value) {
		super();
		this.value = value;
	}

	public List<Value> getValue() {
		return value;
	}

	public void setValue(List<Value> value) {
		this.value = value;
	}
	
	
	
	

}
