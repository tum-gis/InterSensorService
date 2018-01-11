package org.tum.gis.minisos.dataSource;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

public class DataSource {

	private int id;
	private DataSourceConnection dataSourceConnection;
	
	
	
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
	
	
}
