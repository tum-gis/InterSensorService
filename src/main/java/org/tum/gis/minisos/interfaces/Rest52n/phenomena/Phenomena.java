/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n.phenomena;


/**
 * @author kchaturvedi
 *
 */
public class Phenomena {

	private String id = "1";	
	private String href = "http://localhost:8080/phenomena/1";
	private String domainId = "temperature";
	private String label = "temperature";
	
	public Phenomena() {
		
	}
	public Phenomena(String id, String href, String domainId, String label) {
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

	/*public String getHref() {
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
	}*/

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
