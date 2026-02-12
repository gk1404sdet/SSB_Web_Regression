Feature: Verify the guest user Functionality

  Background:
    Given user launches the application

  @regression @TC_007
  Scenario: Verifying website loads for guest user
    Given user is on the homepage
    Then User validates categories from homepage
    And User validates search from homepage

  @regression @TC_008
  Scenario: Verifying navigation of banners, menus & footer as guest user
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then user is on the homepage
    And user scroll into footer and click Terms of use from homepage
    And user validates footer from homepage

  @regression @TC_009
  Scenario: Verifying search functionality in guest mode
    Given user is on the homepage
    Then user enters keyword in searchBox
    And User validates makeup label from makeup PLP

  @regression @TC_010
  Scenario: Verifying strip banner and navigation to FCC page with benefits as guest user
    Given user is on the homepage
    Then user clicks strip banner
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status
    When system should display the following components in the FCC section after clicking strip banner
      | FIRST CONNECT |
      | SILVER EDGE   |
      | GOLDEN GLOW   |
      | PLATINUM AURA |
      | BLACK         |

  @regression @TC_015
  Scenario: Verifying guest can add product to cart from PLP
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the add to bag
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |

  @regression @TC_014
  Scenario: Verifying guest user can add product to cart from PDP
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    And User clicks on the add to bag in PDP
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |

  @regression @TC_016
  Scenario: Verifying cart page loads for guest user
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the add to bag
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user validates product remove x mark
    And user validate increase and decrease product quantity in the cart
    When User clicks on the proceed to pay
    And user validate login id entry page

  @regression @TC_017
  Scenario: Verifying guest user is prompted to log in when clicking the Wishlist icon
    Given user is on the homepage
    When user clicks on the wishlist icon in the header
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status
    And user validate that wishlist is not empty

  @regression @TC_011
  Scenario: Verifying PLP loads relevant products
    Given user is on the homepage
    When user selects a skin category from home page
    And user clicks the sub category from skin page
    And user validates products sort by
    Then User clicks on the price high to low from sort by
    And Validate high to low price in sort by
    Then User clicks on brand filter
    And User selects arcelia filter from brand
    And User validate arcelia label from filtered brand
    Then User add first PLP product as wishlist
    And user validate login id entry page

  @regression @TC_012
  Scenario: Verifying PDP loads for guest user
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then system should display the following components on the PDP page
      | prize           |
      | offer           |
      | description     |
      | similar product |
      | review          |
    Then User add product to wishlist in PDP
    And user validate login id entry page
    Then User clicks close in login page
    And User clicks on the add to bag in PDP
    When user clicks on the cart icon in the header
    And user validate that cart is not empty

  @regression @TC_013
  Scenario: Verifying guest user can add product to cart from PDP and Cart Widgets
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    And User clicks on the add to bag in PDP
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |
    And User clicks on the move to bag
    And User validate the products in cart
    Then User validate the product count in cart

  @regression @TC_018
  Scenario: Verifying guest user is prompted to log in when click Proceed to Pay & cart items merge after login
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the add to bag
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And User validate the product in cart
    And User clicks on the proceed to pay
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And User validate the product in cart

    ### Wishlist Feature testcase - Guest User ###

  @regression @TC_155
  Scenario: Verifying guest user gets login prompt when performing wishlist actions
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    And user validate login id entry page
