package org.tum.gis.interSensorService.dataSourceConnection.openSensors.observations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {

	@JsonProperty("encoding")
	private String encoding;
	@JsonProperty("content-type")
	private String contentType;
	@JsonProperty("text")
	private String text;
	
	public Payload() {
		
	}
	
	
	public Payload(String encoding, String contentType, String text) {
		super();
		this.encoding = encoding;
		this.contentType = contentType;
		this.text = text;
	}


	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
