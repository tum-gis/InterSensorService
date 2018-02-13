/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.thingspeak;

/**
 * @author kchaturvedi
 *
 */
public class Channel {

	private String name;
	private String description;
	private String created_at;
	private String updated_at;
	
	public Channel() {
		
	}
	
	public Channel(String name, String description, String created_at, String updated_at) {
		super();
		this.name = name;
		this.description = description;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
