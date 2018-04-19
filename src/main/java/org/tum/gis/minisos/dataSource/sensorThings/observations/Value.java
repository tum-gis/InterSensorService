package org.tum.gis.minisos.dataSource.sensorThings.observations;

public class Value {

	private String phenomenonTime;
	private String result;
	private String resultTime;
	
	public Value() {
		
	}
	
	public Value(String phenomenonTime, String result, String resultTime) {
		super();
		this.phenomenonTime = phenomenonTime;
		this.result = result;
		this.resultTime = resultTime;
	}
	public String getPhenomenonTime() {
		return phenomenonTime;
	}
	public void setPhenomenonTime(String phenomenonTime) {
		this.phenomenonTime = phenomenonTime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultTime() {
		return resultTime;
	}
	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}
	
	
}
