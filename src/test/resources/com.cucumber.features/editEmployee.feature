Feature: Validation of edit function

  Scenario Template: Edit Employee
    Given I am on the Benefits Dashboard page
    When select the Edit  button
    And  an Employer should be able to edit employee "<firstName>" "<lastName>" "<dependents>"
    Then the employee should save
    Then the data should change in the table "<firstName>" "<lastName>" "<dependents>"
    Examples:
      | firstName | lastName | dependents |
      | Sally     | Parker   | 2          |

  @delete
  Scenario: Delete Employee
    Given an Employer
    And I am on the Benefit Dashboard page
    When I click the Action X
    Then the employee should be deleted