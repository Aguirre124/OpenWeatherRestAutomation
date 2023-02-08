Feature: Consult the current weather data using Latitude and Longitude

  Background:
    Given load the data for the test
      | latitude | longitude |               apikey             |
      |   10.01  |   20.02   | 77131eade0789ee05882eee65fe6dc51 |

  Scenario: Consume of the service successfully using the Latitude and Longitude parameters
    When use the service with the Latitude and Longitude parameters
    Then see the status code is 200

  Scenario: Validate response body
    When call get user API
    Then validate the schema response "GetJsonLatitudeSchema"
