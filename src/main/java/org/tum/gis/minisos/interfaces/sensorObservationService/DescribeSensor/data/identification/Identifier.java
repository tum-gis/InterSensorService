package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.identification;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Identifier {

	@JacksonXmlProperty (isAttribute = true)
	private String name = "uniqueId";
	
	private Term term = new Term();

	public Identifier() {
		
	}
	
	public Identifier(String name, Term term) {
		super();
		this.name = name;
		this.term = term;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}
	
	
}
