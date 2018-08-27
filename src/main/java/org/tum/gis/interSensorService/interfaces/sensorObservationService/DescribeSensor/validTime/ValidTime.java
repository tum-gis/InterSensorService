package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.validTime;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ValidTime {

	private TimePeriod timePeriod = new TimePeriod();
	
	@JacksonXmlProperty (isAttribute = true)
	private String id;

	public ValidTime() {
		
	}
	
	public ValidTime(TimePeriod timePeriod, String id) {
		super();
		this.timePeriod = timePeriod;
		this.id = id;
	}

	public TimePeriod getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(TimePeriod timePeriod) {
		this.timePeriod = timePeriod;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
