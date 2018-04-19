package org.tum.gis.minisos.dataSourceConnection.openSensors.observations;

public class Message {

	private String date;
	private Double value = 1.0;
	
	public Message() {
		
	}
	
	public Message(String date, Double value) {
		super();
		this.date = date;
		this.value = value;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	
	
}
