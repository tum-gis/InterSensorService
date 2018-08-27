package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.outputs;

import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.position.Uom;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Quantity {

	@JacksonXmlProperty (isAttribute = true)
	private String definition;
	
	private Uom uom = new Uom();

	public Quantity() {
		
	}
	
	public Quantity(String definition, Uom uom) {
		super();
		this.definition = definition;
		this.uom = uom;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}
	
	
}
