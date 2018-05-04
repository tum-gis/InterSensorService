package org.tum.gis.minisos.dataSourceConnection.openSensors.observations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Observations {

	@JsonProperty("messages")
	private List<Message> messages;
	
	@JsonProperty("next")
	private String next;

	public Observations() {
		
	}
	
	

	public Observations(List<Message> messages, String next) {
		super();
		this.messages = messages;
		this.next = next;
	}



	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}



	public String getNext() {
		return next;
	}



	public void setNext(String next) {
		this.next = next;
	}
	
	
	
	
}
