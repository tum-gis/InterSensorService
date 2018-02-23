/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tum.gis.minisos.interfaces.Rest52n.api.API;
import org.tum.gis.minisos.interfaces.Rest52n.phenomena.Phenomena;
import org.tum.gis.minisos.interfaces.Rest52n.procedures.Procedures;
import org.tum.gis.minisos.interfaces.Rest52n.services.Services;
import org.tum.gis.minisos.interfaces.Rest52n.station.Station;
import org.tum.gis.minisos.interfaces.Rest52n.stations.Stations;
import org.tum.gis.minisos.interfaces.Rest52n.timeseries.Timeseries;
import org.tum.gis.minisos.interfaces.Rest52n.station.TimeseriesCollection;
import org.tum.gis.minisos.interfaces.Rest52n.station.Timseries;

/**
 * @author kchaturvedi
 *
 */
@Service
public class Rest52nService {

	public List<API> getAPI(){
		API node1 = new API("services","Service Provider","A service provider offers timeseries data.");
		API node2 = new API("stations","stations","A service provider offers timeseries data.");
		API node3 = new API("timeseries","timeseries","A service provider offers timeseries data.");
		API node4 = new API("categories","categories","A service provider offers timeseries data.");
		API node5 = new API("offerings","offerings","A service provider offers timeseries data.");
		API node6 = new API("features","features","A service provider offers timeseries data.");
		API node7 = new API("procedures","procedures","A service provider offers timeseries data.");
		API node8 = new API("phenomena","phenomena","A service provider offers timeseries data.");
		API node9 = new API("platforms","platforms","A service provider offers timeseries data.");
		API node10 = new API("datasets","datasets","A service provider offers timeseries data.");
		API node11 = new API("geometries","geometries","A service provider offers timeseries data.");
		List<API> list1 = new ArrayList<>(Arrays.asList(node1,node2,node3,node4,node5,node6,node7,node8,node9,node10,node11));
		return list1;
	}
	

	
	public List<Services> getServices(){
		List<Services> list1 = new ArrayList<>();
		Services service = new Services();
		list1.add(service);
		return list1;
	}
	
	public List<Stations> getStations(){
		List<Stations> list1 = new ArrayList<>();
		Stations stations = new Stations();
		list1.add(stations);
		return list1;
	}
	
	public Station getStation(){
		
		Station station = new Station();
		
		return station;
	}
	
	public Procedures getProcedure() {
		Procedures procedure = new Procedures();
		return procedure;
	}
	
	public List<Phenomena> getPhenomena(){
		List<Phenomena> list1 = new ArrayList<>();
		Phenomena phenomena = new Phenomena();
		list1.add(phenomena);
		return list1;
	}
	
	public Timeseries getTimeseriesMetadata(){
		Timeseries timeseries = new Timeseries();		
		return timeseries;
	}
	
	public static void main(String[] args) {
		HashMap <String, TimeseriesCollection> mapper = new HashMap();
		mapper.put("1", new TimeseriesCollection());
		
		System.out.println(mapper);
	}
	
	
	
}
