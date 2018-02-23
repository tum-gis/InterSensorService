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
public class SupportedMimeTypes {

	private List<String> quantity = new ArrayList<>(Arrays.asList("image/png","application/pdf","application/json","text/csv","application/zip"));
	private List<String> count = new ArrayList<>(Arrays.asList("application/json"));
	private List<String> text = new ArrayList<>(Arrays.asList("application/json"));
	
	public SupportedMimeTypes() {
		
	}
	
	public SupportedMimeTypes(List<String> quantity, List<String> count, List<String> text) {
		super();
		this.quantity = quantity;
		this.count = count;
		this.text = text;
	}
	public List<String> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<String> quantity) {
		this.quantity = quantity;
	}
	public List<String> getCount() {
		return count;
	}
	public void setCount(List<String> count) {
		this.count = count;
	}
	public List<String> getText() {
		return text;
	}
	public void setText(List<String> text) {
		this.text = text;
	}
	
	
}
