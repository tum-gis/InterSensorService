# Data Model
Upon establishing the connection successfully to a data source, the InterSensor Service generates three primary classes as shown below:

![Alt text](../../theme/img/DataModel.png?raw=true "DataModel")

These classes act as an intermediate layer to define the details of data source and encode observations according to the standardized interfaces. Assuming the serever host name is 127.0.0.1 and the port is 8080, the service can be used with the help of the following links:
```
#Base URL
http://127.0.0.1/inter-sensor-service/

#Accessing DataSource details
http://127.0.0.1/inter-sensor-service/datasources - Get a list of all data sources
http://127.0.0.1/inter-sensor-service/datasources/{id} - Get a data source by id

#Accessing Timeseries metadata
http://127.0.0.1/inter-sensor-service/timeseries - Get a list of all timeseries
http://127.0.0.1/inter-sensor-service/timeseries/{id} - Get a timeseries by id

#Accessing Observations
http://127.0.0.1/inter-sensor-service/timeseries/{id}/observations?start=2018-08-01T00:00:00Z&end=2018-08-02T00:00:00Z
```
The above-mentioned requests determine data source connection properties by the given IDs, establish the connections, retrieve the observations within the temporal filter, and model according to the Observation class. 

# Standardized external interfaces
The observations from each data source can be encoded "on-the-fly" according to the international OGC Sensor Web Enablement (SWE) standards mentioned as follows:

## OGC SensorThings API
[SensorThings API](http://www.opengeospatial.org/standards/sensorthings) is a new standard providing an open and unified framework to interconnect IoT sensing devices, data, and applications over the Web. It is REST-ful, lightweight and based on JSON. 

The observations from established InterSensor Service can be queried according to the SensorThings API by simply using the following commands
```
#Base URL for the SensorThings API standard
http://127.0.0.1/OGCSensorThingsApi/v1.0

#Thing
http://127.0.0.1/OGCSensorThingsApi/v1.0/Things

#Location
http://127.0.0.1/OGCSensorThingsApi/v1.0/Locations

#HistoricalLocation
http://127.0.0.1/OGCSensorThingsApi/v1.0/HistoricalLocations

#Datastream
http://127.0.0.1/OGCSensorThingsApi/v1.0/Datastreams

#Sensor
http://127.0.0.1/OGCSensorThingsApi/v1.0/Sensors

#Observations (This is currently supported only with temporal filters)
http://127.0.0.1/OGCSensorThingsApi/v1.0/Observations?$filter=phenomenonTime lt '2018-08-10T00:00:00' and phenomenonTime ge '2018-08-15T00:00:00'

#ObservedProperties
http://127.0.0.1/OGCSensorThingsApi/v1.0/ObservedProperties

#FeaturesOfInterest
http://127.0.0.1/OGCSensorThingsApi/v1.0/FeaturesOfInterest
```
More details about the OGC SensorThings API operations can be found [here](https://developers.sensorup.com/docs/).

Please note that the InterSensor Service currently does not support all the operations of the SensorThings API. It is a work in progress. 

## OGC Sensor Observation Service
[Sensor Observation Service](http://www.opengeospatial.org/standards/sos) (SOS) is a widely adopted web service to query sensor description and metadata and real-time observations. It comprises of well-defined operations such as DescribeSensor to retrieve sensor description according to the SensorML standard and GetObservation to retrieve real-time observations according to the Observations and Measurements (O&M) standard.

The observations from established InterSensor Service can be queried according to the O&M format by simply using the following GetObservation request
```
#GetObservation Request for the InterSensor Service
http://127.0.0.1/OGCSensorThingsApi/v1.0/ogc-sos-webapp/service?service=SOS&version=2.0.0&request=GetObservation&temporalFilter=om:phenomenonTime,2018-08-05T00:00:00/2018-08-05T05:00:00
```
More details about the OGC SensorThings API operations can be found [here](http://www.opengeospatial.org/standards/sos).

Please note that the InterSensor Service currently does not support GetCapabilities and DescribeSensor operations. It is a work in progress.

## 52° North Timeseries API
[Timeseries API](http://sensorweb.demo.52north.org/sensorwebclient-webapp-stable/api-doc/) developed by 52°North is a REST-ful web binding to the OGC Sensor Observation Service. It allows querying and visualizing sensor locations and their observations on the so-called [Helgoland client](https://github.com/52North/helgoland).

The observations from established InterSensor Service can be queried according to Timeseries API by using the following command:
```
#Base URL for the 52°North Timeseries
http://127.0.0.1:8080/52n-rest-api
```
The above-mentioned command can simply be provided to the Helgoland client in order to visualize and interact with the timeseries data. 



