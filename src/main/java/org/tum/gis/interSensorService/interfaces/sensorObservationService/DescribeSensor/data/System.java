package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data;

import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.capabilities.Capabilities;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.contact.Contact;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.identification.Identification;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.keywords.Keywords;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.outputs.Outputs;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.position.Position;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.validTime.ValidTime;

public class System {

	private Keywords keywords = new Keywords();
	private Identification identification = new Identification();
	private ValidTime validTime = new ValidTime();
	
	private Capabilities capabilities = new Capabilities();
	private Contact contact = new Contact();
	private Position position = new Position();
	//private Inputs inputs;
	private Outputs outputs = new Outputs();
	
	
	public System() {
		
	}
	
	
	public System(Keywords keywords, Identification identification, ValidTime validTime, Capabilities capabilities,
			Contact contact, Position position, Outputs outputs) {
		super();
		this.keywords = keywords;
		this.identification = identification;
		this.validTime = validTime;
		this.capabilities = capabilities;
		this.contact = contact;
		this.position = position;
		this.outputs = outputs;
	}


	public Keywords getKeywords() {
		return keywords;
	}
	public void setKeywords(Keywords keywords) {
		this.keywords = keywords;
	}
	public Identification getIdentification() {
		return identification;
	}
	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
	public ValidTime getValidTime() {
		return validTime;
	}
	public void setValidTime(ValidTime validTime) {
		this.validTime = validTime;
	}
	public Capabilities getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(Capabilities capabilities) {
		this.capabilities = capabilities;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public Outputs getOutputs() {
		return outputs;
	}


	public void setOutputs(Outputs outputs) {
		this.outputs = outputs;
	}
	
	
	
}
