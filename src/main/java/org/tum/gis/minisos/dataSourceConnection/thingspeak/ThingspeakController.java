/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.thingspeak;

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
	public void addDataSource(@RequestBody ThingspeakConnection thingspeakConnection) {
		thingspeakService.addDataSource(thingspeakConnection);
	}
}
