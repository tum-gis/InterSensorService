package org.tum.gis.interSensorService.interfaces.sensorThingsApi.historicalLocations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricalLocations {

	@JsonProperty("@iot.count")
	private int count;
	private List<HistoricalLocation> value;
	
	public HistoricalLocations() {
		
	}
	
	public HistoricalLocations(int count, List<HistoricalLocation> value) {
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
	public List<HistoricalLocation> getValue() {
		return value;
	}
	public void setValue(List<HistoricalLocation> value) {
		this.value = value;
	}
	
	
}
