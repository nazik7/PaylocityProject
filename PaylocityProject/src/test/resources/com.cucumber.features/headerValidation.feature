Feature: Validation of Headers
  Scenario: Validation of Main Header
    When the user navigate to login page
    And provide valid username "testUser"
    Then provide valid password "Test1234"
    And click login button
    Then validate the header "Benefits Dashboard"

    Scenario: validate the Table Headers
      Then the user validate the following table headers
        | ID           |
        | Last Name    |
        | First Name   |
        | Salary       |
        | Dependents   |
        | Gross Pay    |
        | Benefit Cost |
        | Net Pay      |
        | Actions      |