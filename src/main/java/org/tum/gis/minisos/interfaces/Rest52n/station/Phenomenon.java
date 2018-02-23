package org.tum.gis.minisos.interfaces.Rest52n.station;

public class Phenomenon {

	private String id = "1";
	private String label = "temperature";
	
	public Phenomenon() {
			
	}
	
	public Phenomenon(String id, String label) {
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
