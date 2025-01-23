@runScenario
Feature: User is on Login Page

  Background: 
    Given user is on LambdaTest Playground dashboard page

  Scenario: user on Login page and trying to login to the application
    When user trying to hover the mouse on  My account menu item
    And user clicks on the "Login" button
    And user gets the title of the login page "Account Login"
    Then user will verify "Returning Customer" text on the login page
    And user enters
      | userName            | passWord     |
      | nilava.pal@test.com | Kolkata8431@ |
    And user click on the "Login" button
    Then user navigate to "My Account" page
