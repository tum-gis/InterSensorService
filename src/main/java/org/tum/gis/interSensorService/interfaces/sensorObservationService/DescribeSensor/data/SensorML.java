package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data;

public class SensorML {

	private Member member = new Member();

	public SensorML() {
		
	}
	
	public SensorML(Member member) {
		super();
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
