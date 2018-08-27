package org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.readings;

public class Units {

	private String tag;
	private String name;
	private String prefix;
	private String suffix;
	
	public Units() {
		
	}
	
	public Units(String tag, String name, String prefix, String suffix) {
		super();
		this.tag = tag;
		this.name = name;
		this.prefix = prefix;
		this.suffix = suffix;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
}
