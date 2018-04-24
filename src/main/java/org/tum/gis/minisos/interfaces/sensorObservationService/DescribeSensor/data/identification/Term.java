package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.identification;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Term {

	@JacksonXmlProperty (isAttribute = true)
	private String definition = "urn:ogc:def:identifier:OGC:1.0:uniqueID";
	
	private String value = "UniqueID";

	public Term() {
		
	}
	
	public Term(String definition, String value) {
		super();
		this.definition = definition;
		this.value = value;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
