package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.offerings;

public class Offering {

	private String id = "1";
	private String label = "Offering_MiniSOS_Virtual_Sensor";
	
	public Offering() {
		
	}
	
	public Offering(String id, String label) {
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
