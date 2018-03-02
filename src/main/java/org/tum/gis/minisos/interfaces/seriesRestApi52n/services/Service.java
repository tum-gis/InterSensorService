package org.tum.gis.minisos.interfaces.seriesRestApi52n.services;

public class Service {

	private String id = "1";
	private String label = "My RESTful Dataset Service";
	
	public Service() {
		
	}
	
	public Service(String id, String label) {
		super();
		this.id = id;
		this.label = label;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
