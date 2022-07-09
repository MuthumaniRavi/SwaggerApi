@login @RunAll
Feature: Login module API Automation

  Scenario: Get the user logtoken from the login endpoint
    Given user add header
    And User add basic authendication for login
    When User send "POST" request for login endpoint
    Then User verify status code is 200
    And User verify the login response body firstname present "MUTHUMANI" and get the logtoken
