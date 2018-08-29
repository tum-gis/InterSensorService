# Adding a CSV connection to the InterSensor Service
In many scenarios, timeseries values are stored in a basic files such as CSV. For example, [this](./../../theme/files/Export_From_Weather_Station.csv) CSV file contains timeseries about temperature readings exported from a weather station.  

In order to add the temperature readings from the above-mentioned CSV file to the InterSensor Service, the configuration file (*application.yml*) should be configured as 

```
datasource-connection:
  name: "CSV_WeatherStation"
  description: "CSV File having temperature readings recorded by a weather station"
  connectionType: "CSV"
  observationProperty: "Temperature"
  observationType: "OM_Measurement"
  unitOfMeasure: "Celsius"
  fileLocation: "C:/fileLocation/fileName.csv"  # Please change the path accordingly
  separator: ";"  # please use the appropriate separator character 
  timeBeginColumn: 3 # the column number of the observation time (column numbers start from 0)
  valueColumn: 4 # the column number of the observation value (column numbers start from 0)
  latitude: 51.53883 # location of the weather station
  longitude: -0.01664 # location of the weather station
```

After configuring the details, the InterSensor Service will be able to connect to this data source and encode observations according to the standardized external interfaces. For more details about the endpoints, please refer to the [Documentation](./../APIDocumentation/RefDoc.md)
