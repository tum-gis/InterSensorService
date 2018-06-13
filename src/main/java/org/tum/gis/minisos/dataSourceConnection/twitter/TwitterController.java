package org.tum.gis.minisos.dataSourceConnection.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterController {

	@Autowired
	private TwitterService twitterService;
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST, value="/datasourcesTwitter")
	public void addDataSource(@RequestBody TwitterConnection twitterConnection) {
		twitterService.addDataSource(twitterConnection);
	}
}
