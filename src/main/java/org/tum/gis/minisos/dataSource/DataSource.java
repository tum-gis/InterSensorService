package org.tum.gis.minisos.dataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

public class DataSource {

	private int id;
	private DataSourceConnection dataSourceConnection;	
	private List<Double> coordinates = new ArrayList<>(Arrays.asList(11.566464,48.150175)); //default Chair of Geoinformatics, TU Munich
	
	
	
	public DataSource(int id, DataSourceConnection dataSourceConnection) {
		super();
		this.id = id;
		this.dataSourceConnection = dataSourceConnection;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DataSourceConnection getDataSourceConnection() {
		return dataSourceConnection;
	}
	public void setDataSourceConnection(DataSourceConnection dataSourceConnection) {
		this.dataSourceConnection = dataSourceConnection;
	}
	public List<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
}
