@runThis
Feature: Login in to the application and verify mouse hover menu content

  Scenario: 1. Login to the Lambda Test playgorund application and verify  mouse hover menu content from menu bar
    Given Login to the application
      | userName            | passWord     |
      | nilava.pal@test.com | Kolkata8431@ |
   Then verify mouse hover menu content from menu bar
   
