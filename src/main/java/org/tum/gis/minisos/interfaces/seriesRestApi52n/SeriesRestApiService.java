package org.tum.gis.minisos.interfaces.seriesRestApi52n;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.ListObservation52n;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.categories.Category;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.features.Feature;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.geomteries.Geometry;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.offerings.Offering;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.phenomena.Phenomenon;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.procedures.Procedure;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.services.Services;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.stations.Station;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.stations.Stations;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries.FlotData;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries.FlotSeries;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries.TimeseriesMetadata;
import org.tum.gis.minisos.observation.ObservationService;



@Service
public class SeriesRestApiService {

	@Autowired
	private ObservationService observationService;
	
	public List<Services> serviceList = new ArrayList<>();
	public List<Procedure> procedureList = new ArrayList<>();
	public List<Phenomenon> phenomenonList = new ArrayList<>();
	public List<Stations> stationsList = new ArrayList<>();
	public List<Station> stationList = new ArrayList<>();
	public List<Category> categoryList = new ArrayList<>();
	public List<Geometry> geometryList = new ArrayList<>();
	public List<Offering> offeringList = new ArrayList<>();
	public List<Feature> featureList = new ArrayList<>();
	public List<TimeseriesMetadata> timeseriesMetadataList = new ArrayList<>();
	
	
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
		return phenomenonList;
	}
	
	public List<Stations> getStations(){		
		return stationsList;
	}
	
	public Station getStation() {		
		return stationList.get(0);
	}
	
	public TimeseriesMetadata getTimeseriesMetadata() {		
		return timeseriesMetadataList.get(0);
	}
	
	public Procedure getProcedure() {		
		return procedureList.get(0);
	}
	
	public List<Services> getServices(){		
		return serviceList;		
	}
	
	public Services getService(){			
		return serviceList.get(0);		
	}
	
	public FlotSeries getFlotSeries(String startTime, String endTime) throws IOException, ParseException {
		FlotSeries flotSeries = new FlotSeries();
		ListObservation52n listObservation52n = observationService.getObservationList(1, startTime, endTime, "abc");
		List<Number[]> values = new ArrayList<>();
		FlotData flotData = new FlotData();
		for (int i=0;i<listObservation52n.getValues().size();i++) {
			List<Number> value = new ArrayList<>();
			
			
			value.add(listObservation52n.getValues().get(i).getTimestamp());						
			value.add(listObservation52n.getValues().get(i).getValue());
			
		
			
			values.add(value.toArray(new Number[0]));
			
			
		}
		flotData.setValues(values);
		flotSeries.setFlotData(flotData);
		return flotSeries;
	}
	
	//create an initializer that reads data from Mini SOS and creates all components in one go!
	public void seriesRestApi52nFormatter(DataSourceConnection dataSource) {
		Geometry geometry = new Geometry();
		geometryList.add(geometry);
		
		Phenomenon phenomenon = new Phenomenon();		
		phenomenon.setLabel(dataSource.getObservationProperty());
		phenomenonList.add(phenomenon);
		
		Stations stations = new Stations();
		stationsList.add(stations);
		
		Services services = new Services();
		serviceList.add(services);
		
		Procedure procedure = new Procedure();
		procedure.setLabel(dataSource.getName());
		procedureList.add(procedure);		
		
		
		Category category = new Category();
		category.setLabel(dataSource.getObservationProperty());
		categoryList.add(category);
		
		Offering offering = new Offering();
		offering.setLabel(dataSource.getName());
		offeringList.add(offering);
		
		Feature feature = new Feature();
		featureList.add(feature);
		
		Station station = new Station();
		station.getProperties().getTimeseries().getTimeseriesIdentifierCollection().setCategory(category);
		station.getProperties().getTimeseries().getTimeseriesIdentifierCollection().setFeature(feature);
		station.getProperties().getTimeseries().getTimeseriesIdentifierCollection().setOffering(offering);
		station.getProperties().getTimeseries().getTimeseriesIdentifierCollection().setPhenomenon(phenomenon);
		station.getProperties().getTimeseries().getTimeseriesIdentifierCollection().setProcedure(procedure);
		station.getProperties().getTimeseries().getTimeseriesIdentifierCollection().setService(services);
		stationList.add(station);
		
		TimeseriesMetadata timeseriesMetadata = new TimeseriesMetadata();
		timeseriesMetadata.getParameters().setCategory(category);
		timeseriesMetadata.getParameters().setFeature(feature);
		timeseriesMetadata.getParameters().setOffering(offering);
		timeseriesMetadata.getParameters().setPhenomenon(phenomenon);
		timeseriesMetadata.getParameters().setProcedure(procedure);
		timeseriesMetadata.getParameters().setServices(services);
		timeseriesMetadata.setUom(dataSource.getUnitOfMeasure());
		timeseriesMetadataList.add(timeseriesMetadata);
		
	}
	
}

