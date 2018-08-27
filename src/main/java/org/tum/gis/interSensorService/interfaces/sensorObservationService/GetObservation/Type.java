package org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Type {

	@JacksonXmlProperty (isAttribute = true, localName = "href")
	private String href = "http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement";

	public Type() {
		
	}
	public Type(String href) {
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
