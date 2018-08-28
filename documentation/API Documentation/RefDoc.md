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
(This request determines data source connection properties by the given id, 
                         establishes the connection, 
                         retrieves the observations within the temporal filter,
                         and models according to the Observation class) 
```

# Standardized external interfaces
The observations from each data source can be encoded "on-the-fly" according to the international OGC Sensor Web Enablement (SWE) standards mentioned as follows:

## OGC SensorThings API
SensorThings API is a new standard providing an open and unified framework to interconnect IoT sensing devices, data, and applications over the Web. It is REST-ful, lightweight and based on JSON. 

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
More details about the OGC SensorThings API requests can be found [here](https://developers.sensorup.com/docs/).

Please note that the InterSensor Service currently does not support all the operations of the SensorThings API. It is a work in progress. 

## OGC Sensor Observation Service
## 52° North Timeseries API


InterSensor Service is a new lightweight web service allowing users to connect to multiple sensor and IoT platforms and retrieving their observations without worrying about data storage and the multitude of different APIs.  It is a Java application based on the Spring framework and is available as free and Open Source.

# Architecture
![Alt text](theme/img/Architecture.png?raw=true "Architecture")
The architecture of the InterSensor Service comprises of the following layers:
## Data Adapters
The data adapters allows establishing connections to not only platforms such as ThingSpeak, OpenSensors or Weather Underground, but also to external databases, CSV files, Cloud based spreadsheets, GPS feeds, and real-time Twitter feeds. While querying, the service opens a data source connection and retrieves the observations based on querying parameters directly from the data source. 
## Standardized External Interfaces
The retrieved sensor observations can be encoded "on-the-fly" according to international standardized interfaces such as the OGC Sensor Observation Service and OGC SensorThings API. It allows linking numerous sensor data streams from heterogeneous sensor platforms with existing sensor web infrastructures. 

# Getting Started
Please perform the following intstructions:
#### Step 1:
Clone the GitHub repository and install the application
```
git clone https://github.com/kanishk-chaturvedi/InterSensorService.git
cd InterSensorService
mvn clean install
```
By default, it will generate an application JAR file and a configuration file (*application.yml*). If you prefer to work with WAR files, it can also be generated. See [details](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging).

#### Step 2:
Configure the data source connection details inside the *application.yml* file. The templates for configuration files are provided [here](yamlTemplates).
Please move the modified *application.yml* file in the same folder where the JAR file is located (Execution of JAR file looks for the YAML file in the same folder).
```
cd target
java -jar <filename.jar>
```
#### Step 3:
Upon successful data source connection, the application will start running. For example, if your server is 127.0.0.1 and the port is 8080, the homepage can be accessed using http://127.0.0.1:8080/inter-sensor-service/
The InterSensor Service determines the host address and port from configuration files and generates the URLs. 

For more details, please refer to documentation and tutorials.
