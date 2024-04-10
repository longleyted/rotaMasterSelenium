@outOfScope
Feature: Book a demo - negative scenarios
  Scenario Outline: Book a demo - missing message
    Given I am on the rotaMaster website
    And I navigate to book a demo
    And I assert book a demo page
    When I enter a first name
    And I enter a last name
    And I change amount of staff "<amountOfStaff>"
    And I enter an organisation name
    And I enter a valid email address
    And I click on request demo
    Then I see the error message "There was a problem with your submission. Please review the fields below."

    Examples:
      | amountOfStaff |
      | 5-25          |
      | 25-50         |
      | 50-100        |
      | 100-500       |
      | 1000+         |