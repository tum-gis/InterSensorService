package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.contact;

public class ContactList {
	private Member member = new Member();

	public ContactList() {
		
	}
	
	public ContactList(Member member) {
		super();
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	

}
