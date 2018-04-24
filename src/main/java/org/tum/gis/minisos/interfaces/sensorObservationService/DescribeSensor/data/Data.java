package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data;

public class Data {

	private SensorML sensorML = new SensorML();

	public Data() {
		
	}
	
	public Data(SensorML sensorML) {
		super();
		this.sensorML = sensorML;
	}

	public SensorML getSensorML() {
		return sensorML;
	}

	public void setSensorML(SensorML sensorML) {
		this.sensorML = sensorML;
	}
	
	
}
