/**
 * 
 */
package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kchaturvedi
 *
 */


public class GetObservationResponse {

	
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
