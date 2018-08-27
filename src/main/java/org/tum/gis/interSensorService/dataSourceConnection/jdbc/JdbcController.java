/**
 * 
 */
package org.tum.gis.interSensorService.dataSourceConnection.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kchaturvedi
 *
 */
@RestController
public class JdbcController {

	@Autowired
	private JdbcService jdbcService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/jdbc")
	public void addDataSource(@RequestBody JdbcConnection jdbcConnection) {
		jdbcService.addDataSource(jdbcConnection);
	}
	
	@RequestMapping("/testJdbc")
	public List<JdbcObservation> getAllObservations(){
		return jdbcService.getAllObservation();
	}
}
