package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.contact;

public class Phone {

	private String voice = "+498928922974";

	
	public Phone() {
		
	}
	public Phone(String voice) {
		super();
		this.voice = voice;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}
	
	
}
