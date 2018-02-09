package org.tum.gis.minisos.observation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
public class ObservationService {

	//public List<Observation> observationList = new ArrayList<>();
	
	public List<ObservationListManager> observationList = new ArrayList<>();
	
	
	//getObservation() - if type is CSV, parse CSV and return List of CSV Object
	
	/*
	 getObservation(id){
	 	return List<Observation> for that id
	 }
	 
	 */
	
	public List<Observation> getObservationList(int id){
		return observationList.get(id-1).getObservationList();
	}
	
	public List<Observation> getObservationList(int id, String startTime, String endTime) throws ParseException {
		DateTime start = DateTime.parse(startTime);
		DateTime end = DateTime.parse(endTime);
	
		List<Observation> originalList = observationList.get(id-1).getObservationList();
		List<Observation> queriedList = new ArrayList<>();
		for (int i=0;i<originalList.size();i++) {
			if(DateTime.parse(originalList.get(i).getTime()).isAfter(start)&&DateTime.parse(originalList.get(i).getTime()).isBefore(end)) {
				queriedList.add(originalList.get(i));
			}
		}
		return queriedList;
	}
}
