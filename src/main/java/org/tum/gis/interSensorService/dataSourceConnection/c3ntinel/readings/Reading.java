package org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.readings;

public class Reading {

	private long time;
	private double value;
	private String status;
	
	
	public Reading() {
		
	}
	
	public Reading(long time, double value, String status) {
		super();
		this.time = time;
		this.value = value;
		this.status = status;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
