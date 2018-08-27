package org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PhenomenonTime {

	@JacksonXmlProperty (isAttribute = true)
	private String id = "phenomenonTime_1";
	
	private TimeInstant timeInstant = new TimeInstant();

	public PhenomenonTime() {
		
	}
	
	public PhenomenonTime(TimeInstant timeInstant) {
		super();
		this.timeInstant = timeInstant;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TimeInstant getTimeInstant() {
		return timeInstant;
	}

	public void setTimeInstant(TimeInstant timeInstant) {
		this.timeInstant = timeInstant;
	}
	
	
}
