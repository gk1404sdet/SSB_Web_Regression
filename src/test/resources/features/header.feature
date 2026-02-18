Feature: Verify the Header Functionality

  Background:
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status

  @smoke @sanity @regression
  Scenario: Verify the Wishlist Functionality
    When User clicks on the wishlist icon in the header
    And User validate that wishlist icon navigate to the wishlist page
    And User select a product from wishlist page
    And User validate that it navigates to the PDP
    And User clicks on the wishlist icon in the header
    And User adds a product to the cart from the wishlist page
    And User validate that product add to cart successfully
    Then User removes a product from the wishlist page
    And User clicks on the remove item for removing product from wishlist
    And User validate that product removed from wishlist

  @smoke @sanity @regression
  Scenario: Verify the Search Functionality
    When User clicks on the search bar
    And user enters keyword in searchBox
#    And User validate that search option navigation to the relevant products
    Then User clicks on the search bar
    And User clicks on trending products
#    And User validate that search option navigation to the relevant products

  @regression @TC_026
  Scenario: Verifying count on the cart icon on the header across all pages
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the add to bag
    Then User validate cart count incremented value

  @regression @TC_031
  Scenario: Verifying strip banner and navigation to FCC page with benefits
    Given user is on the homepage
    Then user clicks strip banner logged in user
    When system should display the following components in the FCC section
      | FIRST CONNECT |
      | SILVER EDGE   |
      | GOLDEN GLOW   |
      | PLATINUM AURA |
      | BLACK         |



