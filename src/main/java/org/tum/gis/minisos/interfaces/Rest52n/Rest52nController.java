/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tum.gis.minisos.interfaces.Rest52n.api.API;
import org.tum.gis.minisos.interfaces.Rest52n.phenomena.Phenomena;
import org.tum.gis.minisos.interfaces.Rest52n.procedures.Procedures;
import org.tum.gis.minisos.interfaces.Rest52n.services.Services;
import org.tum.gis.minisos.interfaces.Rest52n.station.Station;
import org.tum.gis.minisos.interfaces.Rest52n.stations.Stations;
import org.tum.gis.minisos.interfaces.Rest52n.timeseries.FlotSeries;
import org.tum.gis.minisos.interfaces.Rest52n.timeseries.Timeseries;
import org.tum.gis.minisos.observation.ObservationService;

/**
 * @author kchaturvedi
 *
 */
@RestController
public class Rest52nController {

	@Autowired
	private Rest52nService rest52nService;
	
	@Autowired
	private ObservationService observationService;
	
	@RequestMapping(value = "/api/services/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Services> getServices(@RequestParam (value = "expanded") String expanded,
						  			  @RequestParam (value = "locale") String locale){
		return rest52nService.getServices();
	}
	
	@RequestMapping(value = "/api/services/1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Services getService(@RequestParam (value = "expanded") String expanded,
						  			  @RequestParam (value = "locale") String locale){
		return rest52nService.getService();
	}
	
	@RequestMapping(value = "/api/procedures/1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Procedures getProcedure(
						  			  @RequestParam (value = "locale") String locale){
		return rest52nService.getProcedure();
	}
	
	@RequestMapping(value = "/api/stations/2", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Station getStation(
						  			  @RequestParam (value = "locale") String locale){
		return rest52nService.getStation();
	}
	
	@RequestMapping(value = "/api/stations/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Stations> getStations(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "service") String service){
		return rest52nService.getStations();
	}
	
	@RequestMapping(value = "/api/phenomena/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Phenomena> getPhenomena(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "platformTypes") String platformTypes,
			  @RequestParam (value = "service") String service){
		return rest52nService.getPhenomena();
	}
	
	@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<API> getAPI(){
		return rest52nService.getAPI();
	}
	
	@RequestMapping(value = "/api/timeseries/t1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Timeseries getTimeseriesMetadata(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "expanded") String expanded,
			  @RequestParam (value = "force_latest_values") String force_latest_values,
			  @RequestParam (value = "rendering_hints") String rendering_hints,
			  @RequestParam (value = "status_intervals") String status_intervals){
		return rest52nService.getTimeseriesMetadata();
	}
	
	/*@RequestMapping(value = "/api/timeseries/t1/getData", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ListObservation52n getObservationList(
												@RequestParam (value = "expanded") String startTime,
												@RequestParam (value = "generalize") String endTime,
												@RequestParam (value = "format") String format,
												@RequestParam (value = "locale") String locale,
												@RequestParam (value = "timespan") String timespan) throws ParseException, IOException{
		//find a way to take only Rest52n as input to the value of format
		//then, create multiple functions with same name returning different types
		return observationService.list52n;
	}*/
	
	@RequestMapping(value = "/api/timeseries/t1/getData", produces = {MediaType.APPLICATION_JSON_VALUE})
	public FlotSeries getFlotSeries(@RequestParam (value = "expanded") String startTime,
			@RequestParam (value = "generalize") String endTime,
			@RequestParam (value = "format") String format,
			@RequestParam (value = "locale") String locale,
			@RequestParam (value = "timespan") String timespan) throws ParseException, IOException {
		return rest52nService.getFlotSeries();
	}
	
}
