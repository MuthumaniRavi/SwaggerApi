@Address  @RunAll
Feature: Address module API Automation
@newAddress
  Scenario Outline: Verify the add new address to the application through API
    Given User add headers and bearer authendication for accessing address endpoint
    When User add request body for add address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>"and"<address_type>"
    When User send "POST" request for add new address
    Then User verify status code is 200
    And User verify the created address response message matches with "Address added successfully" and get address id

    Examples: 
      | first_name | last_name | mobile     | apartment        | state | city | country | zipcode | address      | address_type |
      | saravana   | suriya    | 8610988167 | pomtreeApartment |    33 |   22 |      44 |  641501 | thuraippakam | home         |
@updateAddress
  Scenario Outline: Verify update the existing address to the application through API
    Given User add headers and bearer authendication for accessing address endpoint
    When User add request body for update address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>"and"<address_type>"
    When User send "PUT" request for update the address
    Then User verify status code is 200
    And User verify the updated address response message matches with "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment        | state | city | country | zipcode | address      | address_type |
      | saravana   | suriya    | 8610988167 | pomtreeApartment |    33 |   22 |      44 |  641501 | thuraippakam | home         |
@getAddress
  Scenario: Verify get address to the application through API
    Given User add headers and bearer authendication for accessing address endpoint
    When User send "GET" request for get the address
    Then User verify status code is 200
    And User get response body for address and verify the get address response message matches with "OK"
@deleteAddress
  Scenario: Verify the delete address to the application through API
    Given User add headers and bearer authendication for accessing address endpoint
    When User add request body for delete address
    When User send "Delete" request for delete address
    Then User verify status code is 200
    And User verify the deleted address response message matches with "Address deleted successfully"
