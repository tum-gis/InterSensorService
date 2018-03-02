package org.tum.gis.minisos.interfaces.seriesRestApi52n;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import org.tum.gis.minisos.interfaces.seriesRestApi52n.phenomena.Phenomenon;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.procedures.Procedure;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.stations.Station;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.stations.Stations;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries.TimeseriesMetadata;



@Service
public class SeriesRestApiService {

	public List<SeriesRestApi> getSeriesRestApi(){
		SeriesRestApi node1 = new SeriesRestApi("services","Service Provider","A service provider offers timeseries data.");
		SeriesRestApi node2 = new SeriesRestApi("stations","stations","A service provider offers timeseries data.");
		SeriesRestApi node3 = new SeriesRestApi("timeseries","timeseries","A service provider offers timeseries data.");
		SeriesRestApi node4 = new SeriesRestApi("categories","categories","A service provider offers timeseries data.");
		SeriesRestApi node5 = new SeriesRestApi("offerings","offerings","A service provider offers timeseries data.");
		SeriesRestApi node6 = new SeriesRestApi("features","features","A service provider offers timeseries data.");
		SeriesRestApi node7 = new SeriesRestApi("procedures","procedures","A service provider offers timeseries data.");
		SeriesRestApi node8 = new SeriesRestApi("phenomena","phenomena","A service provider offers timeseries data.");
		SeriesRestApi node9 = new SeriesRestApi("platforms","platforms","A service provider offers timeseries data.");
		SeriesRestApi node10 = new SeriesRestApi("datasets","datasets","A service provider offers timeseries data.");
		SeriesRestApi node11 = new SeriesRestApi("geometries","geometries","A service provider offers timeseries data.");
		List<SeriesRestApi> list1 = new ArrayList<>(Arrays.asList(node1,node2,node3,node4,node5,node6,node7,node8,node9,node10,node11));
		return list1;
	}
	
	public List<Phenomenon> getPhenomenon(){
		List<Phenomenon> list = new ArrayList<>();
		Phenomenon phenomenon = new Phenomenon();
		list.add(phenomenon);
		return list;
	}
	
	public List<Stations> getStations(){
		List<Stations> list = new ArrayList<>();
		Stations stations = new Stations();
		list.add(stations);
		return list;
	}
	
	public Station getStation() {
		Station station = new Station();
		return station;
	}
	
	public TimeseriesMetadata getTimeseriesMetadata() {
		TimeseriesMetadata timeseriesMetadata = new TimeseriesMetadata();
		return timeseriesMetadata;
	}
	
	public Procedure getProcedure() {
		Procedure procedure = new Procedure();
		return procedure;
	}
}

