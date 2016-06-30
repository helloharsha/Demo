@login
Feature: login Page
  Provide access to demo nopcommerce website

  Scenario Outline: client Login
    Given As a user I navigate to "http://demo.nopcommerce.com/login"
    And I enter username as "<username>" and password as "<password>"
    When I click submit button
    Then I see nopecommerce store

    Examples: 
      | username              | password |
      | helloharsha@ymail.com | sunday   |
