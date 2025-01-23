
Feature: User is on Register Account Page

Background:
  Given user is on LambdaTest Playground dashboard page

  Scenario Outline: User enters personal details
    When user trying to hover the mouse on  My account menu item
    And user clicks on "Register" button
    Then "Register Account" page will be displayed
    And user enters firstName "<FirstName>"
    And user enters LastName "<LastName>"
    And user enters emailId "<E-Mail>"
    And user enters TelephoneNumber "<Telephone>"
    And user enters password "<Password>"
    And user enters confirmPassword "<PasswordConfirm>"
    And user clicks on "Privacy Policy" checkBox
    Then user click on "Continue" button

    Examples: 
      | FirstName | LastName | E-Mail                 | Telephone  | Password     | PasswordConfirm |
   	  | Anuradha  | Guha     | anuradha.guha@test.com | 2443443112 | Kolkata8431@ | Kolkata84321@   |
