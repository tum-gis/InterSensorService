package org.tum.gis.minisos.dataSourceConnection.c3ntinel;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class C3ntinelController {

	@Autowired
	private C3ntinelService c3ntinelService;
	
	@RequestMapping(method=RequestMethod.POST, value="/datasourcesC3ntinel")
	public void addDataSource(@RequestBody C3ntinelConnection c3ntinelConnection) throws ParseException {
		c3ntinelService.addDataSource(c3ntinelConnection);
	}
}
