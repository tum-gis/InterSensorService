package org.tum.gis.minisos.dataSourceConnection.openSensors.observations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Observations {

	@JsonProperty("messages")
	private List<Message> messages;

	public Observations() {
		
	}
	
	public Observations(List<Message> messages) {
		super();
		this.messages = messages;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	
}
