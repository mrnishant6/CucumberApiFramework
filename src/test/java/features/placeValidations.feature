#Author: Nishant Kumar

Feature: Validation of Place API's

  @AddPlace
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>" "<phoneNumber>"
    When User calls "AddPlace" with "post" http method
    Then API call should be successfull with status code as 200
    And "status" in response body should be "OK"
    And "scope" in response body should be "APP"
    And verify place_Id created maps to "<name>" using "getPlace"
    
    Examples:
    |name|language|address|phoneNumber|
    |Nishant|Java|WTC|0987654321|
    
    
    @DeletePlace
    Scenario: Verify if the Delete place functionality is working as expected
    Given DeletePlace Paylod
    When User calls "deletePlace" with "post" http method
    Then API call should be successfull with status code as 200
    And "status" in response body should be "OK"
