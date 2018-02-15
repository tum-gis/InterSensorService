/**
 * 
 */
package org.tum.gis.minisos.interfaces.SosOM;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kchaturvedi
 *
 */

@XmlRootElement
public class GetObservationResponse {

	private List<ObservationData> GetObservationResponse;

	public GetObservationResponse() {
		
	}
	
	public GetObservationResponse(List<ObservationData> getObservationResponse) {
		super();
		GetObservationResponse = getObservationResponse;
	}

	public List<ObservationData> getGetObservationResponse() {
		return GetObservationResponse;
	}

	public void setGetObservationResponse(List<ObservationData> getObservationResponse) {
		GetObservationResponse = getObservationResponse;
	}
	
	
}
