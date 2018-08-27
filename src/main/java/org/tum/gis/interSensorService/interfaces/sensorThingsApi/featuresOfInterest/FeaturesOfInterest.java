package org.tum.gis.interSensorService.interfaces.sensorThingsApi.featuresOfInterest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeaturesOfInterest {
	
	@JsonProperty("@iot.count")
	private int count;
	private List<FeatureOfInterest> value;
	
	public FeaturesOfInterest() {

	}
	
	public FeaturesOfInterest(int count, List<FeatureOfInterest> value) {
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
	public List<FeatureOfInterest> getValue() {
		return value;
	}
	public void setValue(List<FeatureOfInterest> value) {
		this.value = value;
	}
	
	
}
