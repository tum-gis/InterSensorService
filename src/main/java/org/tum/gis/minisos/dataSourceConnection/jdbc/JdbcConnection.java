/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.jdbc;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

/**
 * @author kchaturvedi
 *
 */
public class JdbcConnection extends DataSourceConnection {

	private String datatbaseType;
	private String ipAddress;
	private int port;
	private String databaseName;
	private String username;
	private String password;
	
	public JdbcConnection() {
		
	}
	
	public JdbcConnection(int id, 
						  String name, 
						  String description, 
						  String connectionType,
						  String observationType,			
						  String unitOfMeasure, 
						  String datatbaseType,
						  String ipAddress,
						  int port, 
						  String databaseName, 
						  String username, 
						  String password) {
		super(id, 
			  name, 
			  description, 
			  connectionType, 
			  observationType, 
			  unitOfMeasure);
		
		this.datatbaseType = datatbaseType;
		this.ipAddress = ipAddress;
		this.port = port;
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
	}

	public String getDatatbaseType() {
		return datatbaseType;
	}

	public void setDatatbaseType(String datatbaseType) {
		this.datatbaseType = datatbaseType;
	}
	

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
