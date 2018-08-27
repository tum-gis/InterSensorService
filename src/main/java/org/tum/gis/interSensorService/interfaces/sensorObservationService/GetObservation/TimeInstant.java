package org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation;

public class TimeInstant {

	private String timePosition;

	public TimeInstant() {
		
	}
	
	public TimeInstant(String timePosition) {
		super();
		this.timePosition = timePosition;
	}

	public String getTimePosition() {
		return timePosition;
	}

	public void setTimePosition(String timePosition) {
		this.timePosition = timePosition;
	}
	
	
}
