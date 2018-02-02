package org.tum.gis.minisos.observation;

import org.joda.time.DateTime;

public class Observation {

	private int timeseriesId;
	private String time;
	private double value;
	
	public Observation() {
		
	}
	public Observation(int timeseriesId, String time, double value) {
		super();
		this.timeseriesId = timeseriesId;
		this.time = time;
		this.value = value;
	}
	public int getTimeseriesId() {
		return timeseriesId;
	}
	public void setTimeseriesId(int timeseriesId) {
		this.timeseriesId = timeseriesId;
	}	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
}
