package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Procedure {

	@JacksonXmlProperty (isAttribute = true)
	private String href = "Procedure";
	@JacksonXmlProperty (isAttribute = true)
	private String title = "Procedure";
	
	public Procedure () {
		
	}
	
	public Procedure(String href, String title) {
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
