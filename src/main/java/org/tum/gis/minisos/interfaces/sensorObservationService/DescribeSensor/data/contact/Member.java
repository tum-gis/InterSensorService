package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.contact;

public class Member {

	private ResponsibleParty responsibleParty = new ResponsibleParty();

	public Member() {
		
	}
	
	public Member(ResponsibleParty responsibleParty) {
		super();
		this.responsibleParty = responsibleParty;
	}

	public ResponsibleParty getResponsibleParty() {
		return responsibleParty;
	}

	public void setResponsibleParty(ResponsibleParty responsibleParty) {
		this.responsibleParty = responsibleParty;
	}
	
	
}
