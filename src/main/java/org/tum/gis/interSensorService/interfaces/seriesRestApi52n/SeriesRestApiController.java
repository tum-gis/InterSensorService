package org.tum.gis.interSensorService.interfaces.seriesRestApi52n;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.phenomena.Phenomenon;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.procedures.Procedure;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.services.Services;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.stations.Station;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.stations.Stations;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.timeseries.FlotSeries;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.timeseries.TimeseriesMetadata;


@RestController
public class SeriesRestApiController {

	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/phenomena/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Phenomenon> getPhenomena(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "platformTypes") String platformTypes,
			  @RequestParam (value = "service") String service){
		return seriesRestApiService.getPhenomenon();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/stations/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Stations> getStations(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "service") String service){
		return seriesRestApiService.getStations();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/procedures/1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Procedure getProcedure(
						  			  @RequestParam (value = "locale") String locale){
		return seriesRestApiService.getProcedure();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/stations/2", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Station getStation(
						  			  @RequestParam (value = "locale") String locale){
		return seriesRestApiService.getStation();
	}
		
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/timeseries/1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public TimeseriesMetadata getTimeseriesMetadata(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "expanded") String expanded,
			  @RequestParam (value = "force_latest_values") String force_latest_values,
			  @RequestParam (value = "rendering_hints") String rendering_hints,
			  @RequestParam (value = "status_intervals") String status_intervals){
		return seriesRestApiService.getTimeseriesMetadata();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<SeriesRestApi> getSeriesRestApi(){
		return seriesRestApiService.getSeriesRestApi();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/services/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Services> getServices(@RequestParam (value = "expanded") String expanded,
			  						  @RequestParam (value = "locale") String locale){
		return seriesRestApiService.getServices();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/services/1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Services getService(@RequestParam (value = "expanded") String expanded,
			  				   @RequestParam (value = "locale") String locale) {
		return seriesRestApiService.getService();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/52n-rest-api/timeseries/1/getData", produces = {MediaType.APPLICATION_JSON_VALUE})
	public FlotSeries getFlotSeries(@RequestParam (value = "expanded") String expanded,
			@RequestParam (value = "generalize") String generalize,
			@RequestParam (value = "format") String format,
			@RequestParam (value = "locale") String locale,
			@RequestParam (value = "timespan") String timespan) throws ParseException, IOException, URISyntaxException {
		String[] splitStr = timespan.split("/");
		String startTime = splitStr[0];
		String endTime = splitStr[1];
		return seriesRestApiService.getFlotSeries(startTime,endTime);
	}
}
