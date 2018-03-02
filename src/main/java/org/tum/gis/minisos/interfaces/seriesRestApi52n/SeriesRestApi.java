package org.tum.gis.minisos.interfaces.seriesRestApi52n;

public class SeriesRestApi {

	private String id;
	private String label;
	private String description;
	
	public SeriesRestApi() {
		
	}
	
	public SeriesRestApi(String id, String label, String description) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
