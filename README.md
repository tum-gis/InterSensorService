# InterSensor Service

## Introduction
In many smart city projects, multiple stakeholders and companies are involved who use their own sensors and IoT devices which are managed by different platforms and APIs. In order to work within a common operational framework, sensor web infrastructures play a key role in providing interoperability between heterogeneous sneosr platforms and observations. However, it is unlikely that all stakeholders would be willing to inject their proprietary data into a third-party data storage in the sensor web.

We introduce a new lightweight web service called InterSensor Service, which allows users to connect to multiple IoT platforms, databases and basic files and retrieving their observations without worrying about data storage and the multitude of different APIs.  It is a Java application based on the Spring framework and is available as free and Open Source.

## Architecture
![Alt text](theme/img/Architecture.png?raw=true "Architecture")
The architecture of the InterSensor Service comprises of the following layers:
### Data Adapters
The data adapters allows establishing connections to multiple platforms such as [ThingSpeak](https://thingspeak.com/), [OpenSensors](https://www.opensensors.com/) or [Weather Underground](https://www.wunderground.com/). In addition, users can also connect to timeseries data stored in external databases (such as [PostgreSQL](https://www.postgresql.org/), [Oracle](https://www.oracle.com/index.html)), basic files (such as CSV), Cloud based systems (e.g. [Google Fusion Table](https://developers.google.com/fusiontables/)), GPS Exchange Formats (GPX), and real-time [Twitter feeds](https://developer.twitter.com/en/docs.html) . While querying, the service opens a data source connection and retrieves the observations based on querying parameters directly from the data source. 
### Standardized External Interfaces
The retrieved sensor observations can be encoded "on-the-fly" according to international standardized interfaces such as the [OGC Sensor Observation Service](http://www.opengeospatial.org/standards/sos), [OGC SensorThings API](http://www.opengeospatial.org/standards/sensorthings), and 52° North [Timeseries API](http://sensorweb.demo.52north.org/sensorwebclient-webapp-stable/api-doc/index.html). It allows querying and visualizing numerous sensor data streams from heterogeneous sensor platforms with existing sensor web infrastructures. 

## Getting Started
### Native Installation
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

For more details, please refer to the [documentation](documentation/APIDocumentation/RefDoc.md) and [tutorials](documentation/Tutorials).

### Docker Installation
Coming soon! 

## Demonstrations
An instance of InterSensor Service is being employed in Queen Elizabeth Olympic Park, London under the [Smart District Data Infrastructure framework](http://www.gis.bgu.tum.de/en/projects/smart-district-data-infrastructure/). A list of demonstrations are available [here](documentation/Demonstrations).

## Developers
The InterSensor Service has been conceptualized and developed by the [Chair of Geoinformatics, Technical University of Munich](http://www.gis.bgu.tum.de). 

## License
The InterSensor Service is available as free and open source and is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0). 
