Feature: Consult the current weather data using the name of the city

  Background:
    Given load the data for the test
      |   city   |               apikey             |
      | Medellin | 77131eade0789ee05882eee65fe6dc51 |

  Scenario: Consume of the service successfully using the name of the city
    When use the service with the name of the city as a parameter
    Then see the status code is 200

  Scenario: Validate response body
    When use the service with the name of the city as a parameter
    Then validate the schema response "GetJsonCitySchema"
