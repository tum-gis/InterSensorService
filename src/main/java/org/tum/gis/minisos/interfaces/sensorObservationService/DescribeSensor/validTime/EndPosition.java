package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.validTime;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EndPosition {

	@JacksonXmlProperty (isAttribute = true)
	private String indeterminatePosition = "unknown";

	public EndPosition() {
		
	}
	
	public EndPosition(String indeterminatePosition) {
		super();
		this.indeterminatePosition = indeterminatePosition;
	}

	public String getIndeterminatePosition() {
		return indeterminatePosition;
	}

	public void setIndeterminatePosition(String indeterminatePosition) {
		this.indeterminatePosition = indeterminatePosition;
	}
	
	
}
