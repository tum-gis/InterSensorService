/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.interfaces.Rest52n.api.API;
import org.tum.gis.minisos.interfaces.Rest52n.phenomena.Phenomena;
import org.tum.gis.minisos.interfaces.Rest52n.procedures.Procedures;
import org.tum.gis.minisos.interfaces.Rest52n.services.Services;
import org.tum.gis.minisos.interfaces.Rest52n.station.Station;
import org.tum.gis.minisos.interfaces.Rest52n.stations.Stations;
import org.tum.gis.minisos.interfaces.Rest52n.timeseries.FlotData;
import org.tum.gis.minisos.interfaces.Rest52n.timeseries.FlotSeries;
import org.tum.gis.minisos.interfaces.Rest52n.timeseries.Timeseries;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.interfaces.Rest52n.station.TimeseriesCollection;
import org.tum.gis.minisos.interfaces.Rest52n.station.Timseries;

/**
 * @author kchaturvedi
 *
 */
@Service
public class Rest52nService {

	@Autowired
	private ObservationService observationService;
	//this can be used as it is.
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
	
	public Services getService() {
		List<Services> list2 = getServices();
		return list2.get(0);
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
	
	public FlotSeries getFlotSeries() {
		FlotSeries t1 = new FlotSeries();
		return t1;
	}
	
	/*public FlotSeries getFlotSeries1(String startTime, String endTime) throws IOException, ParseException {
		FlotSeries f1 = new FlotSeries();
		ListObservation52n listObservation52n = observationService.getObservationList(1, startTime, endTime, "abc");
		List<Number[]> values = new ArrayList<>();
		FlotData flot = new FlotData();
		for (int i=0;i<listObservation52n.getValues().size();i++) {
			List<Number> value = new ArrayList<>();
			
			
			value.add(listObservation52n.getValues().get(i).getTimestamp());						
			value.add(listObservation52n.getValues().get(i).getValue());
			
		
			
			values.add(value.toArray(new Number[0]));
			
			
		}
		flot.setValues(values);
		f1.setT1(flot);
		return f1;
	}*/
	
	public static void main(String[] args) {
		
		/*Services services = new Services(); 
		List<Services> list1 = new ArrayList<>();
		list1.add(services);
		List<Services> list2 = list1.stream().map(temp -> {
			Services s1 = new Services();
			s1.setLabel(temp.getLabel());
			s1.setId(temp.getId());
			return s1;
		}).collect(Collectors.toList());*/
		
		String timespan = "2018-03-04T21:59:59+01:00/2018-03-06T01:59:59T01:00";
		String[] str = timespan.split("/");
		System.out.println(str[0]);
		System.out.println(str[1]);
		
		//System.out.println(list2.get(0).getVersion());
	}
	
	
	
}
