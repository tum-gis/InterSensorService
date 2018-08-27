package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.contact;

public class ContactInfo {

	private Phone phone = new Phone();

	public ContactInfo() {
		
	}
	
	public ContactInfo(Phone phone) {
		super();
		this.phone = phone;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	
}
