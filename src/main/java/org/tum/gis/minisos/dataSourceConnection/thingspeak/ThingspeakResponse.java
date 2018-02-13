/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.thingspeak;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author kchaturvedi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThingspeakResponse {

	@JsonProperty("channel")
	private Channel channel;
	
	@JsonProperty("feeds")
	private List<Feed> feed;

	public ThingspeakResponse() {
		
	}
	
	public ThingspeakResponse(Channel channel, List<Feed> feed) {
		super();
		this.channel = channel;
		this.feed = feed;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public List<Feed> getFeed() {
		return feed;
	}

	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}
	
	
	
	
	
}
