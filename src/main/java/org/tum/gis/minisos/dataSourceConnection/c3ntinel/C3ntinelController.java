package org.tum.gis.minisos.dataSourceConnection.c3ntinel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class C3ntinelController {

	@Autowired
	private C3ntinelService c3ntinelService;
	
	@RequestMapping(method=RequestMethod.POST, value="/c3ntinel")
	public void addDataSource(@RequestBody C3ntinelConnection c3ntinelConnection) throws ParseException, JsonProcessingException, URISyntaxException, IOException {
		c3ntinelService.addDataSource(c3ntinelConnection);
	}
}
