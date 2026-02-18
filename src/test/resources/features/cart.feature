Feature: Verify the Cart Page Functionality

  Background:
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status

  @smoke @sanity @regression
  Scenario: Adding the Product to cart
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the add to bag

  @smoke @sanity @regression
  Scenario: Adding the Product to cart
    Given user is on the homepage
    When user selects a hair category from home page
    And user clicks the sub category from hair page
    And user selects a product from plp
    And User clicks on the add to bag

  @smoke @sanity @regression
  Scenario: Adding the Product to cart
    Given user is on the homepage
    When user selects a skin category from home page
    And user clicks the sub category from skin page
    And user selects a product from plp
    And User clicks on the add to bag

  @smoke @sanity @regression
  Scenario: Verify the components of the Bag
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |

  @smoke @sanity @regression
  Scenario: Verify increase and decrease of product quantity
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user increase the product quantity in the cart
    And user decrease the product quantity in the cart

  @smoke @sanity @regression
  Scenario: Verify adding/removing product to bag from PDP and move to Wishlist
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user clicks on the product x mark
    And user moves a product to the wishlist from the cart
    And user validate that product moved to wishlist
    And user validate that cart is not empty
    Then user clicks on the product x mark
    And user removes a product to the wishlist from the cart
    And user validate that product removed from cart

  @smoke @sanity @TC020 @regression
  Scenario: Verify functionality of invalid postal code check on the cart page
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    When User clicks on the proceed to pay
#    Then user clicks on the check option to validate the postal code
    And user enters an invalid postal code
    And system should display the appropriate error message

  @smoke @sanity @TC020 @regression
  Scenario: Verify functionality of valid postal code check on the cart page
#    When user clicks on the cart icon in the header
#    And user validate that cart is not empty
#    Given user clicks on the check option to validate the postal code
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    When User clicks on the proceed to pay
    When user enters the postal code

  @regression @TC_163
  Scenario: Verify Move to Wishlist functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    And user validate that wishlist is not empty

  @regression @TC_172
  Scenario: Verify to ensure redirect to Home via SSB logo
    When user clicks on the cart icon in the header
    And user clicks SSBeauty logo to return to homepage
    Then User validates categories from homepage

  @regression @TC_174
  Scenario: Verify View All on Wishlist widget redirects correctly
    When user clicks on the cart icon in the header
    Then user clicks on the view all from your wishlist in cart page
    And user validate that wishlist is not empty

  @regression @TC_176
  Scenario: Verify basket loading widget functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then system should display the following components on the PDP page
      | price           |
      | offer           |
      | description     |
      | similar product |
      | review          |
    And User clicks on the add to bag in PDP
    And validate basket loading widget while performing actions
    And User validate that product added to cart
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |
    And user clicks on the product x mark
    Then user removes a product to the wishlist from the cart
    And validate basket loading widget while performing actions
    And user validate that cart is empty

  @regression @TC_177
  Scenario: Verify Select Shade functionality on cart page widgets
    Then user enters selectShade product in searchBox
    And User validates product shade popup text
    Then user selects product shade variant in popup
    And User validate that product added to cart
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user verify product shade variant name in cart page

  @regression @TC_178
  Scenario: Verify PDP redirection via View Details & product images
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And Get First Product name from PLP
    And User clicks on the view details
    And User switch new window
    Then system should display the following components on the PDP page
      | price           |
      | offer           |
      | description     |
      | similar product |
      | review          |
    Then Get Product name from PDP trimmed version
    And Validate PLP first product name and PDP product name

  @regression @TC_166
  Scenario: Verify add/remove wishlist functionality on cart page widgets
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    And User remove a product to the wishlist from PLP
    Then User validate that product removed from wishlist

  @regression @TC_161
  Scenario: Verify user can increase/decrease quantity smoothly
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then system should display the following components on the PDP page
      | price           |
      | offer           |
      | description     |
      | similar product |
      | review          |
    And User clicks on the add to bag in PDP
    And User validate that product added to cart from PDP
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |
    Then Get First Product name in the cart page
    And Get First Product quantity count in the cart
    And user increase the product quantity in the cart
    And Get First Product quantity count in the cart after increment
    Then validate increment quantity count from before count after incrementing
    And user decrease the product quantity in the cart
    And Get First Product quantity count in the cart after decrement
    Then validate decrement quantity count from increased quantity count after decrementing

  @regression @TC_158
  Scenario: Verify user can add products to the cart from PDP & PLP
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the add to bag
    And User validate that product added to cart
    And user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then system should display the following components on the PDP page
      | price           |
      | offer           |
      | description     |
      | similar product |
      | review          |
    And User clicks on the add to bag in PDP
    And User validate that product added to cart

  @regression @TC_160
  Scenario: Verify user can remove products using X mark
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user clicks on the product x mark
    Then user removes a product to the wishlist from the cart
    And user validate that product removed from cart
