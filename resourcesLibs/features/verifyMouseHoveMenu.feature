@runThis
Feature: Login in to the application and verify mouse hover menu content

  Background: 
    Given Login to the application
      | userName            | passWord     |
      | nilava.pal@test.com | Kolkata8431@ |

  Scenario: 2. Login to the Lambda Test playgorund application and verify  mouse hover menu content from menu bar
  
    Then verify mouse hover menu content from menu bar

  Scenario Outline: 2. Login to the Lambda Test playgorund application and verify  mouse hover menu content from menu bar based on given menuItem from examples
  
    Then verify mouse hover menu content from menu bar "<menuItem1>", "<menuItem2>" and "<menuItem3>"

    Examples: 
      | menuItem1 | menuItem2 | menuItem3  |
      | Mega Menu | AddOns    | My account1 |
