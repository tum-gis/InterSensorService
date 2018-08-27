/**
 * 
 */
package org.tum.gis.interSensorService.dataSourceConnection.thingspeak;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

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
public class ThingspeakController {

	@Autowired
	private ThingspeakService thingspeakService;
	
	@RequestMapping(method=RequestMethod.POST, value="/thingspeak")
	public void addDataSource(@RequestBody ThingspeakConnection thingspeakConnection) throws UnknownHostException, FileNotFoundException {
		thingspeakService.addDataSource(thingspeakConnection);
	}
}
