/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kchaturvedi
 *
 */
public class Services {

	private String id = "1";
	private String label = "My RESTful Dataset Service";
	private List<String> extras = new ArrayList<>(Arrays.asList("License"));
	private String version = "2.0";
	private String type = "Thin DB access layer service.";
	private SupportedMimeTypes supportedMimeTypes = new SupportedMimeTypes();
	private boolean supportsFirstLatest = true;
	private Quantities quantities = new Quantities();
	
	public Services() {
		
	}
	
	public Services(String id, String label, List<String> extras, String version, String type,
			SupportedMimeTypes supportedMimeTypes, boolean supportsFirstLatest, Quantities quantities) {
		super();
		this.id = id;
		this.label = label;
		this.extras = extras;
		this.version = version;
		this.type = type;
		this.supportedMimeTypes = supportedMimeTypes;
		this.supportsFirstLatest = supportsFirstLatest;
		this.quantities = quantities;
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


	/*public List<String> getExtras() {		
		return extras;
	}


	public void setExtras(List<String> extras) {
		this.extras = extras;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public SupportedMimeTypes getSupportedMimeTypes() {
		return supportedMimeTypes;
	}


	public void setSupportedMimeTypes(SupportedMimeTypes supportedMimeTypes) {
		this.supportedMimeTypes = supportedMimeTypes;
	}


	public boolean isSupportsFirstLatest() {
		return supportsFirstLatest;
	}


	public void setSupportsFirstLatest(boolean supportsFirstLatest) {
		this.supportsFirstLatest = supportsFirstLatest;
	}


	public Quantities getQuantities() {
		return quantities;
	}


	public void setQuantities(Quantities quantities) {
		this.quantities = quantities;
	}	*/ 
	
	
}
