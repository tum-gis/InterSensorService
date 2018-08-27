package org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ResultTime {

	@JacksonXmlProperty (isAttribute = true)
	private String href = "#phenomenonTime_1";

	public ResultTime() {
		
	}
	
	public ResultTime(String href) {
		super();
		this.href = href;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	
}
