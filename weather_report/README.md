# Weather-Report App
Java Case Study – Weather forecast 

# Task
 1. The API should expose a ​“/v1/weather/report”​​ endpoint to retrieve the weather forecast information.  
 2. The​ “/v1/weather/report” ​​endpoint should return a JSON object that gives the below information: 
    * Min/Max temperature of next few days for specific place and region all together.
    * Wind speed information.
    * Other data like phenomenon, places etc.
 
# Tools Used

Spring Boot 2.

Java 11.

Swagger.

Lombok

Mapstruct

Feign Client

## 

Import into your IDE as a gradle project and run.

# Documentation

Documentation can be found [here Swagger-UI](http://localhost:8081/swagger-ui.html) while the project is running 

# Example of usage 

curl -X GET "http://localhost:8081/v1/weather/report" -H "accept: */*" -H "language: eng"
This is a GET request.

On running the above URL with GET method on Swagger or any other rest client of your choice, the API will generate a result as below :

`[
   {
     "date": "2020-05-09",
     "maxTemperature": 17,
     "minTemperature": 2,
     "phenomenon": "Light shower",
     "places": [
       {
         "name": "Harku",
         "phenomenon": "Few clouds",
         "temperature": 4
       },
       {
         "name": "Jõhvi",
         "phenomenon": "Variable clouds",
         "temperature": 6
       },
       {
         "name": "Tartu",
         "phenomenon": "Variable clouds",
         "temperature": 5
       },
       {
         "name": "Pärnu",
         "phenomenon": "Variable clouds",
         "temperature": 5
       },
       {
         "name": "Kuressaare",
         "phenomenon": "Variable clouds",
         "temperature": 7
       },
       {
         "name": "Türi",
         "phenomenon": "Few clouds",
         "temperature": 4
       }
     ],
     "wind": [
       {
         "direction": "Northwest wind",
         "speedMax": 7,
         "speedMin": 2
       },
       {
         "direction": "Westerly winds",
         "speedMax": 8,
         "speedMin": 3
       },
       {
         "direction": "Westerly winds",
         "speedMax": 7,
         "speedMin": 2
       }
     ]
   },
   {
     "date": "2020-05-10",
     "maxTemperature": 18,
     "minTemperature": -1,
     "phenomenon": "Variable clouds"
   },
   {
     "date": "2020-05-11",
     "maxTemperature": 17,
     "minTemperature": 5,
     "phenomenon": "Moderate shower"
   },
   {
     "date": "2020-05-12",
     "maxTemperature": 9,
     "minTemperature": 1,
     "phenomenon": "Light shower"
   }
 ]`
