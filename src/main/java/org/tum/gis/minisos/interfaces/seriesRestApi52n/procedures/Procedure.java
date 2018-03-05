package org.tum.gis.minisos.interfaces.seriesRestApi52n.procedures;

public class Procedure {

	private String id = "1";
	private String label = "MiniSOS_Virtual_Sensor";
	
	public Procedure() {
		
	}
	
	public Procedure(String id, String label) {
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
