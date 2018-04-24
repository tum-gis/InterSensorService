package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.contact;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class OnlineResource {

	@JacksonXmlProperty (isAttribute = true)
	private String href = "www.gis.bgu.tum.de";

	public OnlineResource() {
		
	}
	
	public OnlineResource(String href) {
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
