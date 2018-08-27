package org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FeatureOfInterest {

	@JacksonXmlProperty (isAttribute = true)
	private String href = "FeatureOfInterestName";
	@JacksonXmlProperty (isAttribute = true)
	private String title = "FeatureOfInterestName";

	public FeatureOfInterest() {
		
	}
	public FeatureOfInterest(String href, String title) {
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
