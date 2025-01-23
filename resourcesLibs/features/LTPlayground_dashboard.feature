Feature: Launch LAMBDATEST Playground application and verify the application title, menu items and click on Register Account.

  Background: 
    Given user is on LambdaTest Playground dashboard page

  @smoke
  Scenario: 1. User verifying the appliction title & Menu Items
    When user gets the title of the page
    Then user verify the Application title "Your Store"
    And user trying to hover the mouse on "Mega Menu"
    And user verifying 6 menu item in dashborad page
    Then user gets dashborad menu items
      | Home       |
      | Special    |
      | Blog       |
      | Mega Menu  |
      | AddOns     |
      | My account |

  Scenario: 2. user Hover the mouse on My Account menu item and click on Register
    When user trying to hover the mouse on  My account menu item
    Then user can able to see "Login" and "Register" button
    And user clicks on "Register" button
    Then "Register Account" page will be displayed
    
