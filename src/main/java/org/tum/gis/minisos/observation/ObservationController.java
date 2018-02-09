package org.tum.gis.minisos.observation;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservationController {

	// timeseries/id/observations
	// observationService.getObservation(id);
	
	@Autowired
	private ObservationService observationService;
	
	@RequestMapping(value = "/timeseries/{id}/observations")
	public List<Observation> getObservationList(@PathVariable int id){
		return observationService.getObservationList(id);
	}
	
	@RequestMapping(value = "/timeseries/{id}/observations", params = {"start", "end"})
	public List<Observation> getObservationList(@PathVariable int id,
												@RequestParam (value = "start") String startTime,
												@RequestParam (value = "end") String endTime) throws ParseException{
		return observationService.getObservationList(id,startTime,endTime);
	}
	
}
