package org.tum.gis.minisos.dataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;
import org.tum.gis.minisos.dataSourceConnection.csv.CsvConnection;

@Service
public class DataSourceService {

	//try
	static CsvConnection csv1 = new CsvConnection(1, 
			"csv1", 
			null, 
			"csv", 
			"double", 
			"Celsius", 
			"C:/kanishk/test1.csv",
			",",
			0,
			1);
	
	static DataSource data1 = new DataSource(1, csv1);
	static DataSource data2 = new DataSource(2, new CsvConnection
			(2, 
			"csv1", 
			null, 
			"csv", 
			"double", 
			"Celsius", 
			"C:/kanishk/test2.csv",
			",",
			0,
			1)
			);
	
	public List<DataSource> datasources = new ArrayList<>(Arrays.asList(
			//data1,
			//data2
			));
	
	public List<DataSource> getAllDataSources(){
		return datasources;
	}

	public void addDataSource(DataSource dataSource) {
		datasources.add(dataSource);		
		
	}
	
	public DataSource getDataSource(int id) {
		return datasources.get(id-1);
	}
}
