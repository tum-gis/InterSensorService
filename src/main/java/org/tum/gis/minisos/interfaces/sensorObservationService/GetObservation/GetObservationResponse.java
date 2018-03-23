/**
 * 
 */
package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author kchaturvedi
 *
 */


@JacksonXmlRootElement ( localName = "GetObservationResponse")

public class GetObservationResponse {

	
	@JacksonXmlElementWrapper(useWrapping=false)
	@JacksonXmlProperty(localName="observationData")
	private List<ObservationData> observationData;

	public GetObservationResponse() {		
	}

	public GetObservationResponse(List<ObservationData> observationData) {
		super();
		this.observationData = observationData;
	}

	
	

	public List<ObservationData> getObservationData() {		
		return observationData;
	}
	
	

	public void setObservationData(List<ObservationData> observationData) {
		this.observationData = observationData;
	}
	
	
	
	
}
