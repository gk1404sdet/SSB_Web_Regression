Feature: Verify the Account Module in the Application

  Background:
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status

  @regression
  Scenario: Verify components of Account
    When user hover the profile menu button
    Then system should display the following components in the Account section
      | Profile             |
      | My Orders           |
      | Manage Address      |
      | First Citizen Club  |
      | My Wallet           |
      | Help & Support      |
      | Privacy Policy      |

  @regression
  Scenario: Verify components of FCC page
    When user hover the profile menu button
    And user clicks on the FCC option
    When system should display the following components in the FCC section
      | FIRST CONNECT |
      | SILVER EDGE   |
      | GOLDEN GLOW   |
      | PLATINUM AURA |
      | BLACK         |

  @regression @TC_046
  Scenario: Ensure the navigation to accounts section
    When user hover the profile menu button
    Then user clicks on the my Profile option
    Then Validating the accounts page

  @regression @TC_047
  Scenario: Validate redirection to FCC Page
    When user hover the profile menu button
    Then user clicks on the FCC option
    Then Validating the FCC page

  @regression @TC_048
  Scenario: Ensure View Benefits for All Tiers for FCC user
    When user hover the profile menu button
    Then user clicks on the FCC option
    Then user clicks on first connect card
    Then user validating the benefit for first connect card
    And user clicks on silver card
    Then user validating the benefit for silver card
    And user clicks on platinum card
    Then user validating the benefit for platinum card
    And user clicks on black card
    Then user validating the benefit for black card
    Then user clicks on golden glow card
    Then user validating the benefit for golden glow card

  @regression @TC_051
  Scenario: Ensure FCC cards for non FCC user
    When user hover the profile menu button
    Then user clicks on the FCC option
    And user clicks on silver card
    Then user clicks join now button
    Then Validating FCC cards for FCC users or not

  @regression @TC_052
  Scenario: Ensure “Join Now” & Auto-Upgrade flow for FCC user
    When user hover the profile menu button
    Then user clicks on the FCC option
    And user clicks on silver card
    Then user clicks join now button
    Then Validating Join Now & Auto-Upgrade flow for silver card
    And User clicks close button
    And user clicks on platinum card
    Then user clicks join now button
    And Validating Join Now & Auto-Upgrade flow for Platinum card
    And User clicks close button
    And user clicks on black card
    Then user clicks join now button
    Then Validating Join Now & Auto-Upgrade flow for black card

  @regression @TC_058 @act
  Scenario: Ensure Scroll-to-Top (Up Arrow) button
    When user hover the profile menu button
    Then user clicks on the FCC option
    Then user scroll down the application
    And verifying whether the page on the bottom or not
    Then User click the scroll up button
    Then verifying the page on the top or not

  @regression @TC_060
  Scenario: Ensure navigation to the My Profile Page from account section
    When user hover the profile menu button
    Then user clicks on the my Profile option
    Then user should be navigated to the My Profile page

  @regression @TC_061
  Scenario: Ensure adding or changing the profile picture
    When user hover the profile menu button
    And user clicks on the my Profile option
    Then user clicks on profile image icon
    And user wait two seconds
    And user uploads a valid profile picture
    And user wait two seconds
    Then profile picture should be updated successfully

  @regression @TC_063
  Scenario: Verify CRUD on the Address page
    When user hover the profile menu button
    And user clicks on the manage address
    And user is able to add a new address
    And user enters the new first name
    And user enters the new last name
    And user enters the new number
    And user enters the new pin code
    And user enters the new address
    And user selects a address type as work
    And user clicks on the add address
    And user validate that new address added successfully
    And user updates an existing address
    And user enters the new first name
    And user enters the new last name
    And user enters the new number
    And user enters the new pin code
    And user enters the new address
    And user selects a address type as work
    And user clicks on the save changes
    And Validate that existing address has updated
    And user is able to delete exiting address
    And user clicks on the confirm remove button for delete address
    And user validate that delete address message is displayed

  @regression @TC_064
  Scenario: Ensure navigation to My Orders Section
    When user hover the profile menu button
    Then user clicks on the my orders option
    Then user should be navigated to the My orders page

  @regression @TC_065
  Scenario: Ensure the search functionality of My Orders
    When user hover the profile menu button
    Then user clicks on the my orders option
    And user selects the first product
    And Capture existing Order ID from the list
    Then user hover the profile menu button
    Then user clicks on the my orders option
    Then Enter that value in Search box
    And user selects the first product
    And Capture expected Order ID from the list and validating

  @regression @TC_062
  Scenario: Verify CRUD on the Address page
    When user hover the profile menu button
    And user clicks on the my Profile option
    And user update their first name
    And user update their last name
    And user update their gender details
    And user clicks on the update changes
    And user validate that personal details successfully updated


