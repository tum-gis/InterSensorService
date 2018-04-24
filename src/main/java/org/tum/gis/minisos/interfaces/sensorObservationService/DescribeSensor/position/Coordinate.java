package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.position;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Coordinate {

	@JacksonXmlProperty (isAttribute = true)
	private String name;
	
	private Quantity quantity = new Quantity();

	public Coordinate() {
		
	}
	public Coordinate(String name, Quantity quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}
	
	
}
