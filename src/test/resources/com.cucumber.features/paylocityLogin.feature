Feature: Paylocity Login Functionality

@Positive
Scenario: Login with valid credentials

When the user navigate to login page
And provide valid username "testUser"
Then provide valid password "Test1234"
And click login button


  @Negative
  Scenario: Login with invalid username
    When the user navigate to login page
    And provide invalid username "test"
    Then provide valid password "Test1234"
    And click login button
    Then validate the error message