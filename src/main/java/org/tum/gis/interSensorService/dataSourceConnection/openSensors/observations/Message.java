package org.tum.gis.interSensorService.dataSourceConnection.openSensors.observations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

	
	@JsonProperty("device")
	private String device;
	@JsonProperty("owner")
	private String owner;
	@JsonProperty("topic")
	private String topic;
	@JsonProperty("date")
	private String date;
	@JsonProperty("payload")
	private Payload payload; 
	//private Double value;
	
	public Message() {
		
	}

	public Message(String device, String owner, String topic, String date, Payload payload) {
		super();
		this.device = device;
		this.owner = owner;
		this.topic = topic;
		this.date = date;
		this.payload = payload;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	
	
	
	
}
