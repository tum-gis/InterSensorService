package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.outputs;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Output {

	@JacksonXmlProperty (isAttribute = true)
	private String name;
	
	private Quantity quantity = new Quantity();

	public Output() {
		
	}
	public Output(String name, Quantity quantity) {
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
