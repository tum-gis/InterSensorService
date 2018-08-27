/**
 * 
 */
package org.tum.gis.interSensorService.observation;

import java.util.List;

/**
 * @author kchaturvedi
 *
 */
public class ObservationListManager {

	int timeseriesId;
	List<Observation> observationList;
	public ObservationListManager(int timeseriesId, List<Observation> observationList) {
		super();
		this.timeseriesId = timeseriesId;
		this.observationList = observationList;
	}
	/*public int getTimeseriesId() {
		return timeseriesId;
	}*/
	public void setTimeseriesId(int timeseriesId) {
		this.timeseriesId = timeseriesId;
	}
	public List<Observation> getObservationList() {
		return observationList;
	}
	public void setObservationList(List<Observation> observationList) {
		this.observationList = observationList;
	}
	
	
}
