# Adding Geo-Tagged Tweets to the InterSensor Service
The [Twitter API](https://developer.twitter.com/en/docs.html) is a REST based API allowing to connect to real-time tweets based on user profile and different search parameters such as keywords, geo-location etc. Twitter API supports querying geo-tagged tweets using the [geocode](https://developer.twitter.com/en/docs/tweets/search/guides/standard-operators.html) parameter. It requires a point location (latitude, longitude) and a radius (e.g. 1 km) around that point. Additionally, even a search keyword can also be provided, however, we can leave it blank if we want to retrieve all tweets. However, the response may also include tweets which are not geo-tagged but if their users’ location lie within the search criteria. In order to select appropriate tweets with geo-location, specific JSON node of geo-location needs to be checked if it is null or not. 

In order to connect to the Twitter API, it is required to [register your application with Twitter](https://spring.io/guides/gs/register-twitter-app/). Upon registering, please retrieve **apiKey**, **apiSecret**, **accessToken**, and **accessTokenSecret**. Please provide the details to the configuration file (*application.yml*) as  below:

```
datasource-connection:
  name: "TwitterConnection"
  description: "Geo-Tagged Tweets around a location"
  connectionType: "Twitter"
  observationType: "JsonString"
  unitOfMeasure: "UoM"
  serviceName: "Twitter API"
  serviceType: "JSON"
  baseUrl: "https://api.twitter.com/1.1/search/tweets.json"
  apiKey: "**********"
  apiSecret: "**********"
  accessToken: "**********"
  accessTokenSecret: "**********"
  latitude: 51.54347 #Location of a point
  longitude: -0.01652 #Location of a point
  radius: 1 #Radius in km
```

After configuring the details, the InterSensor Service will be able to connect to this data source and encode observations according to the standardized external interfaces. For more details about the endpoints, please refer to the [Documentation](./../APIDocumentation/RefDoc.md)

Some points to be noted working with the Twitter API are:
* With geo-location search criteria, best results are obtained only within 3 km radius of a location. If we select a larger radius (e.g. 10 km), number of tweets are surprisingly low. It is also discussed [here](https://twittercommunity.com/t/twitter-search-api-always-return-geo-null/66166).
*	Basic free account of Twitter allows only 900 requests within 15 minutes. Also, Twitter response supports pagination containing 100 tweets per page from a search response. That means, for any search criteria, if the response contains 1500 tweets, they will need to be accessed using 15 successive requests. 
*	Basic free account of Twitter allows searching for tweets for only last 7 days. 
