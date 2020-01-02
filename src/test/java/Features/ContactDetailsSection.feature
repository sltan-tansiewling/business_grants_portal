Feature: Contact Details Section
  As an applicant, I should be able to input values for the Main Contact Person and Letter of Offeree in the Contact Details page.

  Background: Applicant logs in
    Given I navigate to the login page
    When I enter the nric as "S1234567A", name as "Tan Ah Kow", uen as "BGPQEDEMO" and role as "Acceptor"
    And I click login button

  Scenario: The page should contain a 'Main Contact Person' subsection
    When I click Proceed on the draft form
    And I click on Contact Details
    Then I should see the input fields: Name, Job Title, Contact No, Email, Alternate Contact Person's Email, Mailing Address

  Scenario: Input valid postal code should auto-populate block number and street details
    When I click Proceed on the draft form
    And I click on Contact Details
    And I input a valid postal code
    Then block number and street details is auto-populated

  Scenario: Mailing address should be auto-populated if select same as registered address in company profile option is checked
    When I click Proceed on the draft form
    And I click on Contact Details
    And I select same as registered address in company profile option
    Then mailing address is auto-populated

  Scenario: The page should contain a 'Letter of Offer Addressee' subsection
    When I click Proceed on the draft form
    And I click on Contact Details
    Then I should see the Letter of Offer Addressee subsection with name, job title and email input fields

  Scenario: Letter of Offer Addressee details should be auto-populated if Same as main contact person option is checked
    When I click Proceed on the draft form
    And I click on Contact Details
    And I select Same as main contact person option
    Then I should see the same name, job title and email populated as entered in main contact person section

  Scenario: Save applicant's response for Contact Details section
    When I click Proceed on the draft form
    And I click on Contact Details
    And I select Same as main contact person option
    And I click Save and reload the page
    Then I should see the same name, job title and email populated as entered in main contact person section