package org.tum.gis.minisos.interfaces.sensorThingsApi.observations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Observation {

	@JsonProperty("@iot.id")
	public int id;
	@JsonProperty("@iot.selfLink")
	public String selfLink;
	public String phenomenonTime;
	public String result;
	public String resultTime;
	
	@JsonProperty("Datastream@iot.navigationLink")
	public String datastream;
	@JsonProperty("FeatureOfInterest@iot.navigationLink")
	public String featureOfInterest;
	
	public Observation() {
		
	}
	
	public Observation(int id, String selfLink, String phenomenonTime, String result, String resultTime,
			String datastream, String featureOfInterest) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.phenomenonTime = phenomenonTime;
		this.result = result;
		this.resultTime = resultTime;
		this.datastream = datastream;
		this.featureOfInterest = featureOfInterest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSelfLink() {
		return selfLink;
	}
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}
	public String getPhenomenonTime() {
		return phenomenonTime;
	}
	public void setPhenomenonTime(String phenomenonTime) {
		this.phenomenonTime = phenomenonTime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultTime() {
		return resultTime;
	}
	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}
	public String getDatastream() {
		return datastream;
	}
	public void setDatastream(String datastream) {
		this.datastream = datastream;
	}
	public String getFeatureOfInterest() {
		return featureOfInterest;
	}
	public void setFeatureOfInterest(String featureOfInterest) {
		this.featureOfInterest = featureOfInterest;
	}
	
	
}
