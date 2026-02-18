Feature: Verify the Wishlist Module in the Application

  Background:
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status

  @regression @TC_095
  Scenario: Ensure navigation to Wishlist page
    When user clicks on the wishlist icon
    Then Validate Wishlist page

  @regression @TC_096
  Scenario: Ensure wishlisted products are seen on the wishlist page along with the count
    When user clicks on the wishlist icon
    Then Validate Wishlist product and count

  @regression @TC_097
  Scenario: Ensure removing products from wishlist
    When user clicks on the wishlist icon
    And user validates the Wishlist page and product count
    Then user removes the product from the Wishlist
    And user clicks on the Remove item button
    And user validates the Wishlist product count after removing the product

  @regression @TC_151
  Scenario: Verifying Wishlist page has back navigation button, SSB Logo, Search icon (App), Bag icon, number of products wishlisted, and X button to remove a product
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    Then system should display the following components on the wishlist page
      | productWishlisted |
      | search            |
      | homeButton        |
      | emptyCartBtn      |
    And User validate that wishlist icon navigate to the wishlist page
    Then User validates wishlist product count in wishlist page
    And user validates product remove x mark in wishlist page

  @sanity @regression
  Scenario: Verifying user remove wishlist items from PDP, PLP, and Wishlist page
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User remove a product to the wishlist from PLP
    And User validate that product removed from wishlist
#    And User adds a product to the wishlist from PLP
#    And User validate that it navigates to the PDP
#    And User adds a product to the wishlist from PLP
#    And User validate that it navigates to the PDP

  @regression @TC_152
  Scenario: Verifying user remove wishlist items from PDP, PLP, and Wishlist page
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then User adds multiple products to wishlist in PLP
    When user clicks on the wishlist icon in the header
    And User deletes wishlisted products from wishlist page

  @regression @TC_153
  Scenario: Verifying user can add products to wishlist from all supported surfaces
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the add to favourite in PDP
    And User validate that product added to wishlist
    Then user enters keyword in searchBox
    And User validates makeup label from makeup PLP
    Then User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    Then User validates 3 wishlist product count in wishlist page
    And User deletes wishlisted products from wishlist page

  @regression @TC_154
  Scenario: Verifying user can remove wishlist items from PDP, PLP, and Wishlist page
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User adds a product to the wishlist from PLP
    Then User validate that product removed from wishlist
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the add to favourite in PDP
    And User validate that product removed from wishlist
    Then user enters keyword in searchBox
    And User validates makeup label from makeup PLP
    Then User adds a product to the wishlist from PLP
    And User validate that product removed from wishlist
    When user clicks on the wishlist icon in the header
    And user validate that wishlist is empty

  @regression @TC_157
  Scenario: Verifying user can open PDP from Wishlist & add wishlist items to cart
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    And user validate that wishlist is not empty
    And User clicks on the view details
    And User switch new window
    And User clicks on the add to bag in PDP
    And User validate that product added to cart

