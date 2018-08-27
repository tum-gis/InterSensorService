package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.capabilities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Text {

	@JacksonXmlProperty (isAttribute = true)
	private String definition = "http://www.opengis.net/def/offering/identifier";
	private String name = "Offering_Name";
	private String value = "Offering_Value";
	
	public Text() {
		
	}
	
	public Text(String definition, String name, String value) {
		super();
		this.definition = definition;
		this.name = name;
		this.value = value;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
