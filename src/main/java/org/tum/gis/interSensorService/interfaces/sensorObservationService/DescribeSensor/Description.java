package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor;

public class Description {

	private SensorDescription sensorDescription = new SensorDescription();

	public Description() {
		
	}
	
	public Description(SensorDescription sensorDescription) {
		super();
		this.sensorDescription = sensorDescription;
	}

	public SensorDescription getSensorDescription() {
		return sensorDescription;
	}

	public void setSensorDescription(SensorDescription sensorDescription) {
		this.sensorDescription = sensorDescription;
	}
	
	
}
