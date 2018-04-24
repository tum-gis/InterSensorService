package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.position;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Quantity {

	@JacksonXmlProperty (isAttribute = true)
	private String axisID;
	
	private Uom uom = new Uom();
	
	private double value;

	public Quantity() {
		
	}
	
	public Quantity(String axisID, Uom uom, double value) {
		super();
		this.axisID = axisID;
		this.uom = uom;
		this.value = value;
	}

	public String getAxisID() {
		return axisID;
	}

	public void setAxisID(String axisID) {
		this.axisID = axisID;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
