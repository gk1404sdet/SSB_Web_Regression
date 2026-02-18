Feature: Verify the product detail page Functionality

 Background:
   Given user launches the application
   When user taps on the Login button
   And user enters a valid mobile number
   And user clicks on the Continue button
   Then user enters the OTP
   And user clicks on the Continue button for OTP validation
   Then system should display the appropriate login status

  @regression @TC_128
  Scenario: Verifying PDP opens via all the triggering points
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
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
    And user enters lipstick in searchBox
    And User validates lipstick label from makeup PLP
    And user selects a product from plp
    And User clicks on the view details
    And user switch window by index
    Then system should display the following components on the PDP page
      | price           |
      | offer           |
      | description     |
      | similar product |
      | review          |

  @regression @TC_129
  Scenario: Verifying components on the PDP
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

  @regression @TC_130  #Comment Background to run this testcase
  Scenario: Verifying brand link functionality
    Given user launches application of a product
    And User validates dotAndKey label from makeup PLP

  @regression @TC_131
  Scenario: Verifying wishlisting the product
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the add to favourite in PDP
    And User validate that product added to wishlist

  @regression @TC_133
  Scenario: Verifying View Similar button
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
    Then User clicks on the view similar products icon in PDP
    And validate chambor brand is present in first 4 products

  @regression @TC_134
  Scenario: Verifying share functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the share icon in PDP
    Then system should display the following components on the share options page
      | share it with friends |
      | facebook              |
      | whatsapp              |
      | pinterest             |
      | email                 |

#  @regression @TC_135 @PDP
#  Scenario: Verifying Offers section on PDP loads correctly and displays all available offers

  @regression @TC_137
  Scenario: Verifying all trust badges are displayed correctly on the PDP
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then system should display all trusted badges components on the PDP page
      | 100%Authentic |
      | Fast Delivery |
      | Free Shipping |

  @regression @TC_138
  Scenario: Verifying Additional Details sections expand/collapse properly and display complete content
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then system should display the following additional details on the PDP page
      | productAdditionalDetails |
      | productDescription       |
      | productHowToUse          |
      | productAboutTheBrand     |
      | review                   |
    And click on view more option from additional details in PDP
    Then click on view less option from additional details in PDP
    And click on view more option from how to use in PDP
    Then click on view less option from how to use in PDP
    And click on view more option from about the brand in PDP
    Then click on view less option from about the brand in PDP

  @regression @TC_139
  Scenario: Verifying adding to cart/wishlist from Similar Products widget
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll to similar products product
    And Move to similar product from PDP and click on add to bag
    And User validate that product added to cart from PDP
    Then User clicks on the add to favourite from similar product in PDP
    And User validate that product added to wishlist

  @regression @TC_140
  Scenario: Verifying adding to cart/wishlist from Similar Products widget
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll to customers also bought product
    And Move to customers also bought from PDP and click on add to bag
    And User validate that product added to cart from PDP
    Then User clicks on the add to favourite from customers also bought in PDP
    And User validate that product added to wishlist

  @regression @TC_141
  Scenario: Verifying adding to cart/wishlist from Similar Products widget
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll to customers also bought product
    And Move to customers also bought from PDP and click on add to bag
    And User validate that product added to cart from PDP
    Then User clicks on the add to favourite from customers also bought in PDP
    And User validate that product added to wishlist

  @regression @TC_143  #manual bug
  Scenario: Verifying Write a Review link functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll and click on write a review
    Then system should display the following components on write a review popup
      | Write a review |
      | add photos     |

  @regression @TC_144
  Scenario: Verifying Write a Review button functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll and click on write a review
    Then system should display the following components on write a review popup
      | Write a review          |
      | Add photos              |
      | Rating for this product |

  @regression @TC_145
  Scenario: Verifying Write a Review button functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll and click on write a review
    And system should display the following components on write a review popup
      | Write a review          |
      | Add photos              |
      | Rating for this product |
    And Select ratings star from write a review popup
    Then User enters review title in review title textbox
    And User enters review description in review title textbox
    And Click on add review button from write a review popup
    Then Validate review submitted message in submitted popup

  @regression @TC_146
  Scenario: Verifying ratings and upload the images or videos in specified size/format
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then user validates foundations label from PLP
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll and click on write a review
    And system should display the following components on write a review popup
      | Write a review          |
      | Add photos              |
      | Rating for this product |
    And Select ratings star from write a review popup
    Then upload photo to review in PDP

  @regression @TC_147
  Scenario: Verifying Add to Bag functionality
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
    Then Get Product name from PDP
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then Get First Product name in the cart page
    And Validate PDP product name and added cart product name

  @regression @TC_148
  Scenario: Verifying “Go to Bag” button displays correctly and redirects user to the Bag/Cart page
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
    Then Get Product name from PDP
    And validate Go To Bag button from PDP
    Then click on Go To Bag button from PDP
    And system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |
    And user validate that cart is not empty
    Then Get First Product name in the cart page
    And Validate PDP product name and added cart product name

  @regression @TC_149
  Scenario: Verifying Quantity Counter (+ / –) updates product quantity correctly and handles min/max limits
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







