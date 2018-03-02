package org.tum.gis.minisos.interfaces.seriesRestApi52n;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.tum.gis.minisos.interfaces.seriesRestApi52n.phenomena.Phenomenon;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.procedures.Procedure;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.stations.Station;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.stations.Stations;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries.TimeseriesMetadata;


@RestController
public class SeriesRestApiController {

	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	@RequestMapping(value = "/api/phenomena1/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Phenomenon> getPhenomena(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "platformTypes") String platformTypes,
			  @RequestParam (value = "service") String service){
		return seriesRestApiService.getPhenomenon();
	}
	
	@RequestMapping(value = "/api/stations1/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Stations> getStations(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "service") String service){
		return seriesRestApiService.getStations();
	}
	
	@RequestMapping(value = "/api/procedures1/1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Procedure getProcedure(
						  			  @RequestParam (value = "locale") String locale){
		return seriesRestApiService.getProcedure();
	}
	
	@RequestMapping(value = "/api/stations1/2", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Station getStation(
						  			  @RequestParam (value = "locale") String locale){
		return seriesRestApiService.getStation();
	}
	
	@RequestMapping(value = "/api/timeseries1/1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public TimeseriesMetadata getTimeseriesMetadata(@RequestParam (value = "locale") String locale,
			  @RequestParam (value = "expanded") String expanded,
			  @RequestParam (value = "force_latest_values") String force_latest_values,
			  @RequestParam (value = "rendering_hints") String rendering_hints,
			  @RequestParam (value = "status_intervals") String status_intervals){
		return seriesRestApiService.getTimeseriesMetadata();
	}
	
	@RequestMapping(value = "/api1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<SeriesRestApi> getSeriesRestApi(){
		return seriesRestApiService.getSeriesRestApi();
	}
}
