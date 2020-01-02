Feature: Eligibility Section
  As an Applicant, I should be able to answer a set of Yes/No Eligibility questions in the Eligibility page.

  Background: Applicant logs in
    Given I navigate to the login page
    When I enter the nric as "S1234567A", name as "Tan Ah Kow", uen as "BGPQEDEMO" and role as "Acceptor"
    And I click login button

  Scenario: Eligibility section should contain 4 questions
    When I click Proceed on the draft form
    Then I should see the eligibility section with 4 questions

  Scenario: Each question should have yes and no radio buttons
    When I click Proceed on the draft form
    Then I should see yes and no radio buttons for each question

  Scenario: Display warning message when answer to any question is No
    When I click Proceed on the draft form
    And I click No for any question
    Then I should see a warning message displayed

  Scenario: Click link in warning message will launch website in new window tab
    When I click Proceed on the draft form
    And I click No for any question
    And I click the link in the warning message
    Then I should see the website launch in a new window tab

  Scenario: Save applicant's response for Eligibility section
    When I click Proceed on the draft form
    And I click No for any question
    And I click Save and reload the page
    Then I should see my applicant's response saved