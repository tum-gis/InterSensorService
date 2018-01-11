package org.tum.gis.minisos.dataSourceConnection.csv;

import org.tum.gis.minisos.dataSource.DataSource;

public class testCSVConnection {

	static CsvConnection csv1 = new CsvConnection(1, 
			"csv1", 
			null, 
			"csv", 
			"double", 
			"Celsius", 
			"C:/kanishk/test1.csv",
			0,
			1);
	
	static DataSource data1 = new DataSource(1, csv1);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(data1.getDataSourceConnection());
	}

}
