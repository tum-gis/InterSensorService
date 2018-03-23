/**
 * 
 */
package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author kchaturvedi
 *
 */


public class ObservationData {

	
	/*private String phenomenonTime;
	
	
	private double value;
	
	public ObservationData() {
		
	}
	
	public ObservationData(String phenomenonTime, double value) {
		super();
		this.phenomenonTime = phenomenonTime;
		this.value = value;
	}

	public String getPhenomenonTime() {
		return phenomenonTime;
	}

	public void setPhenomenonTime(String phenomenonTime) {
		this.phenomenonTime = phenomenonTime;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}*/
	
	@JacksonXmlProperty (localName = "OM_Observation")
	private OM_Observation om_Observation = new OM_Observation();

	public ObservationData() {
		
	}
	
	public ObservationData(OM_Observation om_Observation) {
		super();
		this.om_Observation = om_Observation;
	}

	public OM_Observation getOm_Observation() {
		return om_Observation;
	}

	public void setOm_Observation(OM_Observation om_Observation) {
		this.om_Observation = om_Observation;
	}
	
	
	
	
}
