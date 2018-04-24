package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.position;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Position {

	@JacksonXmlProperty (isAttribute = true)
	private String name = "sensorPosition";
	
	private Position1 position = new Position1();

	public Position() {
		
	}
	
	public Position(String name, Position1 position) {
		super();
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position1 getPosition() {
		return position;
	}

	public void setPosition(Position1 position) {
		this.position = position;
	}
	
	
}
