package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.capabilities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Capabilities {

	@JacksonXmlProperty (isAttribute = true)
	private String name = "offering";
	
	private SimpleDataRecord simpleDataRecord = new SimpleDataRecord();

	public Capabilities() {
		
	}
	
	public Capabilities(String name, SimpleDataRecord simpleDataRecord) {
		super();
		this.name = name;
		this.simpleDataRecord = simpleDataRecord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SimpleDataRecord getSimpleDataRecord() {
		return simpleDataRecord;
	}

	public void setSimpleDataRecord(SimpleDataRecord simpleDataRecord) {
		this.simpleDataRecord = simpleDataRecord;
	}
	
	
}
