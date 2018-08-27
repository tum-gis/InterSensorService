package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.position;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Uom {

	@JacksonXmlProperty (isAttribute = true)
	private String code;

	public Uom() {
		
	}
	
	public Uom(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
