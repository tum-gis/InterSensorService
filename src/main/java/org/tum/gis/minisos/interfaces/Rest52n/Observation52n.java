/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n;

/**
 * @author kchaturvedi
 *
 */
public class Observation52n {

	private long timestamp;
	private double value;
	
	public Observation52n() {
		
	}
	
	public Observation52n(long timestamp, double value) {
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
