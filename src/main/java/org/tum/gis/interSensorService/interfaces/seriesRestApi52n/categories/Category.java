package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.categories;

public class Category {

	private String id = "1";
	private String label = "Temperature";
	
	public Category() {
		
	}
	
	public Category(String id, String label) {
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
