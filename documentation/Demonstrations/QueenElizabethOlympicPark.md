# Queen Elizabeth Olympic Park
An instance of the InterSensor Service is being employed in Queen Elizabeth Olympic Park, London under the Smart District Data Infrastructure (SDDI) framework. This framework allows integrating diverse components such as stakeholders, sensors, IoT devices, simulation tools with a virtual district model which represents the physical reality of the district. As shown in the figure below, for different use cases the district has access to multiple sensors including smart meters (for electricity and gas consumption of important buildings such as the stadium), weather stations (for environmental observations such as temperature, humidity, wind speed etc.), and bat monitoring sensors (for estimating the status of biodiversity of the park). These sensor devices belong to different companies and are based on different platforms. Apart from that, there are also other sensing data such as the Olympic park’s WiFi usages, list of scheduled events in the park, and geo-tagged Twitter feeds, which influence visitor moods and their movements and thus, can be used for efficient and smart planning. In order to bring all sensors within one common operational framework, the InterSensor Service is being used to connect to each data source. It allows encoding all sensors, their descriptions, metadata and recorded real-time observations using common and mature standards (i.e. OGC SWE), as well as querying and analyzing them using common interfaces.
![Alt text](./../../theme/img/Architecture.png?raw=true "Architecture")

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
