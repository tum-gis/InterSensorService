package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.position;

public class Location {

	private Vector vector = new Vector();

	public Location() {
		
	}
	
	public Location(Vector vector) {
		super();
		this.vector = vector;
	}

	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}
	
	
}
