# Adding a Thingspeak connection to the InterSensor Service
[ThingSpeak](https://thingspeak.com/) is an IoT platform that allows users to register different sensors attached to simple microcontrollers such as Arduino and Raspberry Pi, collect and store sensor observations in the Cloud and develop IoT applications. The ThingSpeak platform provides applications to analyze and visualize observations. Upon registering the sensor, its observations can be visualized using the Thingspeak channels. Furthermore, its observations can be retrieved ans queried using a well-defined [REST API](https://de.mathworks.com/help/thingspeak/read-data-from-channel.html).

For example, one publicly available Thingspeak channel is https://thingspeak.com/channels/64242. It shows a DHT22 sensor located in Munich, Germany and comprises of two observation properties: Field 1 (Temperature) and Field 2 (Humidity). 

In order to add a property (e.g. Field 2 - Humidity) from the above-mentioned Thingspeak channel (with id 64242) to the InterSensor Service, the configuration file (*application.yml*) should be configured as 

```
datasource-connection:
  name: "Thingspeak_Humidity_Sensor"
  description: "New thingspeak connection recording Humidity"
  connectionType: "Thingspeak"
  observationProperty: "Humidity_Thingspeak"
  observationType: "OM_Measurement"
  unitOfMeasure: "Percent"
  serviceName: "Thingspeak"
  serviceType: "JSON"
  channel: 64242 
  field: 2
```

After configuring the details, the InterSensor Service will be able to connect to this data source and encode observations according to the standardized external interfaces. For more details about the endpoints, please refer to the [Documentation](./../APIDocumentation/RefDoc.md)

