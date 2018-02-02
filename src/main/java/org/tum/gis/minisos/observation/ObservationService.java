package org.tum.gis.minisos.observation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ObservationService {

	public List<Observation> observationList = new ArrayList<>();
	
	//getObservation() - if type is CSV, parse CSV and return List of CSV Object
	
	/*
	 getObservation(id){
	 	return List<Observation> for that id
	 }
	 
	 */
	
	public List<Observation> getObservationList(){
		return observationList;
	}
}
