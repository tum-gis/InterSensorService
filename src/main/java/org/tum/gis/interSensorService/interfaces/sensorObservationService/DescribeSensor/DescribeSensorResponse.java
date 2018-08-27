package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor;

public class DescribeSensorResponse {

	private String procedureDescriptionFormat = "http://www.opengis.net/sensorML/1.0.1";
	private Description description = new Description();
	public DescribeSensorResponse() {
		
	}
	
	public DescribeSensorResponse(String procedureDescriptionFormat, Description description) {
		super();
		this.procedureDescriptionFormat = procedureDescriptionFormat;
		this.description = description;
	}
	public String getProcedureDescriptionFormat() {
		return procedureDescriptionFormat;
	}
	public void setProcedureDescriptionFormat(String procedureDescriptionFormat) {
		this.procedureDescriptionFormat = procedureDescriptionFormat;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	
	
}
