package org.tum.gis.minisos.interfaces.seriesRestApi52n.phenomena;

public class Phenomenon {

	private String id = "1";
	private String href = "http:/localhost:8080/phenomena/1";
	private String domainId = "Temperature";
	private String label = "Temperature";
	
	public Phenomenon() {
		
	}
	
	
	public Phenomenon(String id, String href, String domainId, String label) {
		super();
		this.id = id;
		this.href = href;
		this.domainId = domainId;
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


	public String getHref() {
		return href;
	}


	public void setHref(String href) {
		this.href = href;
	}


	public String getDomainId() {
		return domainId;
	}


	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	
	
	
}
