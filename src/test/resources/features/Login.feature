Feature: SauceDemo Login functionality
  Verify login, error messages, and logout functionality.

  @smoke
  Scenario: Successful login with standard user
    Given the user is on the login page
    When the user logs in with "standard_user" and "secret_sauce"
    Then the user should be redirected to the inventory page

  Scenario: Successful login with problem user
    Given the user is on the login page
    When the user logs in with "problem_user" and "secret_sauce"
    Then the user should be redirected to the inventory page

  Scenario: Unsuccessful login with empty username
    Given the user is on the login page
    When the user logs in with "" and "secret_sauce"
    Then the error message "Epic sadface: Username is required" should be displayed

  Scenario: Unsuccessful login with empty password
    Given the user is on the login page
    When the user logs in with "standard_user" and ""
    Then the error message "Epic sadface: Password is required" should be displayed

  Scenario: Unsuccessful login with wrong password
    Given the user is on the login page
    When the user logs in with "standard_user" and "wrong_password"
    Then the error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  Scenario: Logout after successful login
    Given the user is logged in as "standard_user"
    When the user opens the burger menu
    And the user clicks the logout link
    Then the user should be redirected to the login page
    And the login page title should be visible
    And the username input field should be visible
    And the login button should be visible
