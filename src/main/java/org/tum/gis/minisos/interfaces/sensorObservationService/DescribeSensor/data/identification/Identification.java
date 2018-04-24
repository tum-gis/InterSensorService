package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.identification;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class Identification {

	@JsonIgnore
	private Identifier identifier = new Identifier();
	
	@JacksonXmlProperty ( localName = "Identifier")
	private List<Identifier> identifierList = new ArrayList<>();

	public Identification() {
		
	}
	
	public Identification(List<Identifier> identifierList) {
		super();
		this.identifierList = identifierList;
	}

	public List<Identifier> getIdentifierList() {
		identifierList.add(identifier);
		return identifierList;
	}

	public void setIdentifierList(List<Identifier> identifierList) {
		this.identifierList = identifierList;
	}
	
	
}
