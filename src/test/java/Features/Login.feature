Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the nric as "S1234567A", name as "Tan Ah Kow", uen as "BGPQEDEMO" and role as "Acceptor"
    And I click login button
    Then I should see My Grants page