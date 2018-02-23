package org.tum.gis.minisos.interfaces.Rest52n.timeseries;

public class TimeValue {

	private long timestamp;
	private double value;
	
	public TimeValue() {
		
	}
	
	public TimeValue(long timestamp, double value) {
		super();
		this.timestamp = timestamp;
		this.value = value;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
}
