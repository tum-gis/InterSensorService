package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor;

import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.Data;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.validTime.ValidTime;

public class SensorDescription {

	private ValidTime validTime = new ValidTime();
	private Data data = new Data();
	public SensorDescription() {
		
	}
	
	public SensorDescription(ValidTime validTime, Data data) {
		super();
		this.validTime = validTime;
		this.data = data;
	}
	public ValidTime getValidTime() {
		return validTime;
	}
	public void setValidTime(ValidTime validTime) {
		this.validTime = validTime;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	
}
