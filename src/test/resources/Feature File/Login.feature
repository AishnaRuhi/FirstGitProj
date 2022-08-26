Feature: Successful Login

  Scenario: Successful login with valid credentials
    Given User Launch Chrome Browser
    When User opens URL
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And User clicks on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Log Out link
    Then Page Title should be "Your store. Login"
    And close browser

  Scenario Outline: Login Data Driven
    Given User Launch Chrome Browser
    When User opens URL
    And User enter Email as "<email>" and Password as "<password>"
    And User clicks on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Log Out link
    Then Page Title should be "Your store. Login"
    And close browser
    Examples:
      | email  | password  |
      | admin@yourstore.com  | admin  |
      | admin@yourstore.com  | admin123  |