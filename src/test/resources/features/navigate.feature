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

  Scenario: Book a demo - invalid email
    Given I am on the rotaMaster website
    And I navigate to book a demo
    And I assert book a demo page
    When I enter a first name
    And I enter a last name
    And I enter an organisation name
    And I enter an invalid email address
    And I click on request demo
    Then I see the error message "There was a problem with your submission. Please review the fields below."
    And I see the error message "The email address entered is invalid, please check the formatting (e.g. email@domain.com)."

  Scenario: Book a demo - blacklisted email
    Given I am on the rotaMaster website
    And I navigate to book a demo
    And I assert book a demo page
    When I enter a first name
    And I enter a last name
    And I enter an organisation name
    And I enter a valid email address
    And I click on request demo
    Then I see the error message "There was a problem with your submission. Please review the fields below."
    And I see the error message "Your email has been blacklisted."

  Scenario: Book a demo - missing first and last name
    Given I am on the rotaMaster website
    And I navigate to book a demo
    And I assert book a demo page
    And I enter an organisation name
    And I enter a valid email address
    And I enter a message
    And I click on request demo
    Then I see the error message "There was a problem with your submission. Please review the fields below."
    And I see the error message "This field is required. Please complete the following fields: First, Last."
