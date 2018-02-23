package org.tum.gis.minisos.interfaces.Rest52n.station;

public class Feature {

	private String id = "2";
	private String label = "Feature_MiniSOS";
	
	public Feature() {
			
	}
	
	public Feature(String id, String label) {
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
