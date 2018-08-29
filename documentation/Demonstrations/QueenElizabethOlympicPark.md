# Queen Elizabeth Olympic Park
An instance of the InterSensor Service is being employed in Queen Elizabeth Olympic Park, London under the Smart District Data Infrastructure (SDDI) framework. This framework allows integrating diverse components such as stakeholders, sensors, IoT devices, simulation tools with a virtual district model which represents the physical reality of the district. As shown in the figure below, for different use cases the district has access to multiple sensors including smart meters (for electricity and gas consumption of important buildings such as the stadium), weather stations (for environmental observations such as temperature, humidity, wind speed etc.), and bat monitoring sensors (for estimating the status of biodiversity of the park). These sensor devices belong to different companies and are based on different platforms. Apart from that, there are also other sensing data such as the Olympic park’s WiFi usages, list of scheduled events in the park, and geo-tagged Twitter feeds, which influence visitor moods and their movements and thus, can be used for efficient and smart planning. In order to bring all sensors within one common operational framework, the InterSensor Service is being used to connect to each data source. It allows encoding all sensors, their descriptions, metadata and recorded real-time observations using common and mature standards (i.e. OGC SWE), as well as querying and analyzing them using common interfaces.

![Alt text](./../../theme/img/QEOPScenario.png?raw=true "Scenario")

## [Demonstration 1](http://129.187.38.43:8080/52n-helgoland-client/#/diagram?timespan=2018-07-12T00:00:00%2B02:00%2F2018-07-15T23:55:00%2B02:00&ts=ISSCSV1__1,MiniSOS9__1,WundergroundChannel__21,ISSCSV3__1,MiniSOS12__1)
Common visualization of heterogeneous sensor observations using 52°North Helgoland Client. In this demonstration, we can interact with observations from a weather station (outside temperature retrieved from Weather Underground platform), smart meters for two important buildings (electricity consumption per minute retrieved from a proprietary C3ntinel platform) and scheduled events in the same important buildings (visitor counts during the sceduled event retreieevd from a CSV file). Such joint visualization is helpful in determining the correlation between different properties, e.g., *"what is the impact of the weather or any scheduled event on the electricity consumption of a building?"*.
![Alt text](./../../theme/img/HelgolandClient_Screenshot1.png?raw=true "Screenshot1")
![Alt text](./../../theme/img/HelgolandClient_Screenshot2.png?raw=true "Screenshot2")

## [Demonstration 2](http://129.187.38.43:8080/sensor-things-charts/demo.html)
Visualization of heterogeneous sensor observations using the [SensorThings HighChart and DataTable library](https://www.sensorup.com/sensorthings-high-chart-and-data-table-hcdt/) developed by SensorUp. 
Please note that due to licensing, this link is just being used for demonstration purpose.

![Alt text](./../../theme/img/SensorThingsHCDT1.png?raw=true "Screenshot1")
![Alt text](./../../theme/img/SensorThingsHCDT2.png?raw=true "Screenshot2")
 
 ## [Demonstration 3](https://goo.gl/AiJMLd)
Visualization of real-time twitter feeds which are geo-tagged within 1 meter radius of the Olympic park. The geo-tagged tweets are retreieved from the InterSensor Service having data connection to the Twitter API. The tweets are visualized along with CityGML building objects of the park on the [3DCityDB-Web-Map-Application](https://github.com/3dcitydb/3dcitydb-web-map).

![Alt text](./../../theme/img/TwitterDemo.png?raw=true "TwitterDemo")


