/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n.procedures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kchaturvedi
 *
 */
public class Procedures {

	private String id = "1";
	private String domainId = "Konigsplatz_Augsburg";
	private String label = "Konigsplatz_Augsburg";
	private List<String> extras = new ArrayList<>(Arrays.asList("License"));
	public Service service = new Service();
	
	public Procedures() {
		
	}
	
	public Procedures(String id, String domainId, String label, List<String> extras, Service service) {
		super();
		this.id = id;
		this.domainId = domainId;
		this.label = label;
		this.extras = extras;
		this.service = service;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*public String getDomainId() {
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
	/*public List<String> getExtras() {
		return extras;
	}
	public void setExtras(List<String> extras) {
		this.extras = extras;
	}*/
	/*public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}*/
	
	
	
}
