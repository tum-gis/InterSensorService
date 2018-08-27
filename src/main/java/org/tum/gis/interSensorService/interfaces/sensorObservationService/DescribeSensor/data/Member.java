package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data;

public class Member {

	private System system = new System();

	public Member() {
		
	}
	
	public Member(System system) {
		super();
		this.system = system;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}
	
	
}
