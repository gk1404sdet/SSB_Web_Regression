Feature: User Login Functionality with Valid and Invalid Data

  @regression @TC002
  Scenario: Verify the sign-in functionality via phone number for an existing user
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status

  @regression @TC003
  Scenario: Verify the invalid sign-in error for invalid mobile number
    Given user launches the application
    When user taps on the Login button
    And user enters an Invalid mobile number
    And user clicks on the Continue button
    Then user validate that the appropriate error message is displayed

  @regression @TC004
  Scenario: Verify the user can request to resend OTP
    Given user launches the application
    When user taps on the Login button
    And user enters a mobile number
    And user clicks on the Continue button
    And user validates that the maximum OTP limit has been reached
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    And user validates that the appropriate OTP error message is displayed
    And user clicks on the Resend button
    And user validates that the OTP is resent successfully

  @regression @TC006
  Scenario: Verify the system shown an error when entering an invalid OTP
    Given user launches the application
    When user taps on the Login button
    And user enters a mobile number
    And user clicks on the Continue button
    And user validates that the maximum OTP limit has been reached
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    And user validates that the appropriate OTP error message is displayed

  @regression @TC109
  Scenario: Verify the logout functionality
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status
    And user hover the profile menu button
    And user clicks on the logout button
    And user validates that the Logout out successfully

