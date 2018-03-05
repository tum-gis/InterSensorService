package org.tum.gis.minisos.interfaces.seriesRestApi52n.services;

public class Services {

	private String id = "1";
	private String label = "My RESTful Dataset Service";
	private String version = "2.0";
	private String type = "MiniSOS access layer service";
	
	public Services() {
		
	}
	
	
	
	public Services(String id, String label, String version, String type) {
		super();
		this.id = id;
		this.label = label;
		this.version = version;
		this.type = type;
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



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
}
