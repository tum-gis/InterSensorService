package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.capabilities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Field {

	@JacksonXmlProperty (isAttribute = true)
	private String name = "Offering_Name";
	
	private Text text = new Text();

	public Field() {
		
	}
	
	public Field(String name, Text text) {
		super();
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	
}
