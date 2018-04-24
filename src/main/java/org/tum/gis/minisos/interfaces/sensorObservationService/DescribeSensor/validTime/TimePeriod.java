package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.validTime;

public class TimePeriod {

	private String beginPosition;
	private EndPosition endPosition = new EndPosition();
	
	public TimePeriod() {
		
	}
	
	public TimePeriod(String beginPosition, EndPosition endPosition) {
		super();
		this.beginPosition = beginPosition;
		this.endPosition = endPosition;
	}
	public String getBeginPosition() {
		return beginPosition;
	}
	public void setBeginPosition(String beginPosition) {
		this.beginPosition = beginPosition;
	}
	public EndPosition getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(EndPosition endPosition) {
		this.endPosition = endPosition;
	}
	
	
}
