Feature: Apply New Grant
  As an Applicant, I should be able to answer a set of Yes/No Eligibility questions in the Eligibility page.

  Background: User logs in
    # Steps: LoginStep
    Given I navigate to the login page
    When I enter the nric as "S1234567A", name as "Tan Ah Kow", uen as "BGPQEDEMO" and role as "Acceptor"
    And I click login button

  Scenario: Apply New Grant
    Given I am on My Grants page
    When I click Get new grant
    And I select a Sector
    And I select a Development Area
    And I select a Functional Area
    And I click Apply button
    Then a draft form for the Grant should be created