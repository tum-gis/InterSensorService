package org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ObservedProperty {

	@JacksonXmlProperty (isAttribute = true)
	private String href = "ObservedPropertyName";
	@JacksonXmlProperty (isAttribute = true)
	private String title = "ObservedPropertyName";

	public ObservedProperty() {
		
	}
	
	public ObservedProperty(String href, String title) {
		super();
		this.href = href;
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
