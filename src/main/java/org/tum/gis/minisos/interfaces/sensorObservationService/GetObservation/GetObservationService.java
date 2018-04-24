package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.IdSequenceManager;

@Service
public class GetObservationService {

	//should read data from ObservationService, created ObservationData, and embed in GetObservationResponse
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
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
	
	
	/*public GetObservationResponse getObservationResponse(int timeseriesId, String startTime, String endTime) throws IOException, ParseException {
		List<Observation> observationList = observationService.getObservationList(timeseriesId, startTime, endTime);		
		List<ObservationData> observationDataList = new ArrayList<>();
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
	
	public GetObservationResponse getObservationResponse(int timeseriesId, String startTime, String endTime) throws IOException, ParseException, URISyntaxException {
		List<Observation> observationList = observationService.getObservationList(timeseriesId, startTime, endTime);		
		List<ObservationData> observationDataList = new ArrayList<>();
		
		AtomicInteger observationSeq = new AtomicInteger();
		for (int i=0; i<observationList.size(); i++) {
			ObservationData observationData = new ObservationData();			
			int observationId = observationSeq.incrementAndGet();
			
			observationData.getOm_Observation().setId("o_"+observationId);
			observationData.getOm_Observation().getPhenomenonTime().setId("phenomenonTime_"+observationId);
			observationData.getOm_Observation().getResultTime().setHref("#phenomenonTime_"+observationId);
			
			observationData.getOm_Observation().getObservedProperty().setHref(timeseriesService.timeseriesList.get(0).getObservationProperty());
			observationData.getOm_Observation().getObservedProperty().setTitle(timeseriesService.timeseriesList.get(0).getObservationProperty());
			
			observationData.getOm_Observation().getPhenomenonTime().getTimeInstant().setTimePosition(observationList.get(i).getTime());
			observationData.getOm_Observation().getResult().setUom(timeseriesService.timeseriesList.get(0).getUnitOfMeasure());
			observationData.getOm_Observation().getResult().setResult(observationList.get(i).getValue());
			observationDataList.add(observationData);
		}		
		GetObservationResponse getObservationResponse = new GetObservationResponse();
		getObservationResponse.setObservationData(observationDataList);		
		return getObservationResponse;
	}
}
