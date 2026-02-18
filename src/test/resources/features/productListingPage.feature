#@PLP
Feature: Verify the product listing page Functionality

  Background:
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status

  @regression @TC_110
  Scenario: Verifying PLP opens via all the triggering points
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    Then user validates foundations label from PLP
    And user enters lipstick in searchBox
    And User validates lipstick label from makeup PLP

  @regression @TC_111
  Scenario: Verifying “View Details” and “Add to Bag” buttons on the product card behave correctly when the user hovers over the card.
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    Then User hover on product and validate options

  @regression @TC_112 @PLP
  Scenario: Verifying PLP shows “Select Shade” & “Select Size” options on hovering for products with variants
    Then user enters selectShade product in searchBox
    Then user validates M.A.C Matte Lipstick - Mehr label from PLP
    And User validates product shade popup text

  @regression @TC_113
  Scenario: Verifying variants (Select Shade & Select Size) ear on hover and function correctly
    Then user enters selectShade product in searchBox
    And User validates product shade popup text
    Then user selects product shade variant in popup
    And User validate that product added to cart
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user verify product shade variant name in cart page

  @regression @TC_114
  Scenario: Verifying product details on the tile along with discounts if any
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then Validate product count for searched keyword
    Then system should display the following components on the PLP page
      | Foundation Label        |
      | Sort By                 |
      | Low To High sort option |
      | High To Low sort option |
      | Filters                 |
      | Brand                   |
    And scroll to bottom of page and click upArrow button from PLP
    Then user validates foundations label from PLP

  @regression @TC_115
  Scenario: Verifying product details on the tile along with discounts if any
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then system should display the following product info on the PLP product

  @regression @TC_116
  Scenario: Verifying applying filters by checking a required filter box
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter

  @regression @TC_117
  Scenario: Verifying single filter functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter

  @regression @TC_118
  Scenario: Verifying single filter functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter

  @regression @TC_119
  Scenario: Verifying Reset button on the filters
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter
    And Click on Clear all button on filters
    Then Get Product name from PLP

  @regression @TC_120
  Scenario: Verifying sort functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then User clicks on the sort option
    And User selects a sort option as price low to high
    And user validates products sort by
    Then User clicks on the price high to low from sort by
    And Validate high to low price in sort by
    Then User clicks on the price low to high from sort by
    And Validate low to high price in sort by

  @regression @TC_121
  Scenario: Verifying Filter and Sort combined functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter
    Then User clicks on the sort option
    And User selects a sort option as price low to high
    And user validates products sort by
    Then User clicks on the price high to low from sort by
    And Validate high to low price in sort by
    Then User clicks on the price low to high from sort by
    And Validate low to high price in sort by

  @regression @TC_122
  Scenario: Verifying wishlisting the product by ting the heart icon
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    And User adds a product to the wishlist from PLP
    Then User validate that product removed from wishlist

  @regression @TC_123
  Scenario: Verifying Add to Cart Button on the product tile
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And User clicks on the add to bag
    And User validate that product added to cart

  @regression @TC_124
  Scenario: Verifying View Details functionality
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

  @regression @TC_125
  Scenario: Verifying PLP shows Free Gift tile for applicable products
    When user enters lipstick in searchBox
    And User validates lipstick label from makeup PLP
    And system should display first product offer tile info on the PLP
    And system should display second product offer tile info on the PLP

  @regression @TC_126
  Scenario: Verifying PLP shows the page topic (Category, Brand, or Search Keyword) with correct product counts
    Then user enters keyword in searchBox
    And User validates makeup label from makeup PLP
    And Validate product count for searched keyword
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    And User selects sugar filter from brand
    Then User clicks on brand filter
    Then User clicks on categories filter
    And User selects face filter from brand
    And User validate face label from filtered brand

  @regression @TC_127
  Scenario: Verifying Scroll-to-Top (Up Arrow) button
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    Then system should display the following components on the PLP page
      | Foundation Label        |
      | Sort By                 |
      | Low To High sort option |
      | High To Low sort option |
      | Filters                 |
      | Brand                   |
    And scroll to bottom of page and click upArrow button from PLP
    Then user validates foundations label from PLP
    And validate upArrow button is not present in the PLP
