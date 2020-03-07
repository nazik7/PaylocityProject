Feature: Validate adding an employee

  @Positive
  Scenario:Login with valid credentials
    When the user navigate to login page
    And provide valid username "testUser"
    Then provide valid password "Test1234"
    And click login button

  Scenario Outline: Add Employee with no Discount
    Given I am on the Benefits Dashboard page
    When I select Add Employee
    Then I should be able to enter firstName "<firstname>"
    And I should be able to enter lastName "<lastname>"
    Then I should be able to enter dependents "<dependents>"
    And First Name does not begin with “A” or “a”
    Then the employee should save
    And I should see the employee in the table "<firstname>" "<lastname>" "<dependents>"
    And the benefit cost calculations are correct
Scenarios:
    |firstname|lastname|dependents|
    |Alan     |Rick    |         |