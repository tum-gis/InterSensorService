package org.tum.gis.minisos.dataSourceConnection.twitter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetSearch {

	@JsonProperty("geo")
	private Geo geo;

	public TweetSearch() {
		
	}

	public TweetSearch(Geo geo) {
		super();
		this.geo = geo;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	
	

	
	
}
