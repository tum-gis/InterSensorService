package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.stations;

public class Properties {

	private String id = "2";
	private String label = "MiniSOS_Virtual_Sensor";
	
	public Properties() {
		
	}
	
	public Properties(String id, String label) {
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
