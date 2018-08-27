package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.timeseries;

public class LastValue {

	private long timestamp = 1518786000000L;
	private double value;
	
	public LastValue() {
		
	}
	
	public LastValue(long timestamp, double value) {
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
