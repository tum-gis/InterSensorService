package org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Result {

	@JacksonXmlProperty (isAttribute = true)
	private String ns = "http://www.opengis.net/gml/3.2";
	@JacksonXmlProperty (isAttribute = true)	
	private String uom = "Celsius";
	@JacksonXmlProperty (isAttribute = true)
	private String type = "ns:MeasureType";
	private double result;
	
	public Result() {
		
	}
	
	public Result(String ns, String uom, String type, double result) {
		super();
		this.ns = ns;
		this.uom = uom;
		this.type = type;
		this.result = result;
	}
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	
}
