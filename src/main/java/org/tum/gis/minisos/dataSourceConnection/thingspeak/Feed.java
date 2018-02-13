/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.thingspeak;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author kchaturvedi
 *
 */
public class Feed {

	private String created_at;
	
	//@JsonProperty("field1")
	private String field1;
	
	private String field2;
	
	
	public Feed() {
		
	}
	
	public Feed(String created_at, String field1, String field2) {
		super();
		this.created_at = created_at;
		this.field1 = field1;
		this.field2 = field2;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public double getField1() {
		field1 = field1.replaceAll("[^\\d.]", "");
		return Double.parseDouble(field1);
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	
	public double getField2() {
		field2 = field2.replaceAll("[^\\d.]", "");
		return Double.parseDouble(field2);
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	
	
	
	
}
