# InterSensor Service
InterSensor Service is a new lightweight web service allowing users to connect to multiple sensor and IoT platforms and retrieving their observations without worrying about data storage and the multitude of different APIs.  It is a Java application based on the Spring framework and is available as free and Open Source.

# Architecture
The architecture of the InterSensor Service comprises of three layers:
## Data Adapters
The data adapters allows establishing connections to not only platforms such as ThingSpeak, OpenSensors or Weather Underground, but also to external databases, CSV files, Cloud based spreadsheets, GPS feeds, and real-time Twitter feeds. While querying, the service opens a data source connection and retrieves the observations based on querying parameters directly from the data source. 
## Standardized External Interfaces
The retrieved sensor observations can be encoded "on-the-fly" according to international standardized interfaces such as the OGC Sensor Observation Service and OGC SensorThings API. It allows linking numerous sensor data streams from heterogeneous sensor platforms with existing sensor web infrastructures. 
