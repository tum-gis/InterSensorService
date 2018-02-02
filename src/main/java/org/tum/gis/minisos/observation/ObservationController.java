package org.tum.gis.minisos.observation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservationController {

	// timeseries/id/observations
	// observationService.getObservation(id);
	
	@Autowired
	private ObservationService observationService;
	
	@RequestMapping("/timeseries/observations")
	public List<Observation> getObservationList(){
		return observationService.getObservationList();
	}
}
