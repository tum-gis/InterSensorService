package org.tum.gis.minisos.dataSourceConnection.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tum.gis.minisos.observation.Observation;

public class TestJdbcConnection {

	@Autowired
	private static JdbcRepository jdbcRepository;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<JdbcObservation> jdbcObservationList = new ArrayList<>();
		List<Observation> observationList2 = new ArrayList<>();
		
			}

}
