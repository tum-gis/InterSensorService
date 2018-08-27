package org.tum.gis.interSensorService.interfaces.sensorThingsApi.locations;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonProperty;

public class Locations {

	@JsonProperty("@iot.count")
	private int count;
	
	private List<Location> value;

	public Locations() {
		
	}
	
	public Locations(int count, List<Location> value) {
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

	public List<Location> getValue() {
		return value;
	}

	public void setValue(List<Location> value) {
		this.value = value;
	}
	
	
	
}
