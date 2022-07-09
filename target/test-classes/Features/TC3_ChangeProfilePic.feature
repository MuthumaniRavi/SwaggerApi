@changeProfilePic  @RunAll
Feature: Change Profile Pic module API Automation

  Scenario: Verify change the profile picture to the application through API
    Given User add headers and bearer authendication for accessing profile endpoint
    When User add multipart for change the profile picture
    When User send "POST" request for change the profile picture
    Then User verify status code is 200
    And User verify the updated profile picture response message matches with "Profile updated Successfully"
