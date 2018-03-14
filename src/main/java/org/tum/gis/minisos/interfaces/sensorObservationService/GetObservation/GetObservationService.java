package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationService;

@Service
public class GetObservationService {

	//should read data from ObservationService, created ObservationData, and embed in GetObservationResponse
	
	@Autowired
	private ObservationService observationService;
	
	/*public GetObservationResponse getObservationResponse(int timeseriesId, String startTime, String endTime) throws IOException, ParseException {
		List<Observation> observationList = observationService.getObservationList(timeseriesId, startTime, endTime);
		List<ObservationData> observationDataList = new ArrayList<>();;
		for (int i=0; i<observationList.size(); i++) {
			ObservationData observationData = new ObservationData();
			observationData.setPhenomenonTime(observationList.get(i).getTime());
			observationData.setValue(observationList.get(i).getValue());
			observationDataList.add(observationData);
		}
		GetObservationResponse getObservationResponse = new GetObservationResponse();
		getObservationResponse.setObservationData(observationDataList);
		return getObservationResponse;
	}*/
	
	public List<ObservationData> getObservationResponse(int timeseriesId, String startTime, String endTime) throws IOException, ParseException {
		List<Observation> observationList = observationService.getObservationList(timeseriesId, startTime, endTime);		
		List<ObservationData> observationDataList = new ArrayList<>();;
		for (int i=0; i<observationList.size(); i++) {
			ObservationData observationData = new ObservationData();
			observationData.setPhenomenonTime(observationList.get(i).getTime());
			observationData.setValue(observationList.get(i).getValue());
			observationDataList.add(observationData);
		}		
		return observationDataList;
	}
}
