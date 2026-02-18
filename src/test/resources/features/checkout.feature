Feature: Verify the Checkout Module in the Application

  Background:
    Given user launches the application
    When user taps on the Login button
    And user enters a valid mobile number
    And user clicks on the Continue button
    Then user enters the OTP
    And user clicks on the Continue button for OTP validation
    Then system should display the appropriate login status

    @regression @TC_179
    Scenario: Ensure navigation to Address page from Cart page
      When user hovers over the categories
      And user clicks on Concealers
      And user validates that the product does not display "No Result Found"
      And user clicks on Select Shade
      And user selects the shade from the pop-up
      Then user clicks on the Add to Bag button
      And user validates that the product is successfully added to the cart
      And user clicks on the cart icon
      And user validates the cart page navigation
      And user clicks on the Proceed to Checkout button
      And user validates the address page navigation



  @smoke @sanity @regression
  Scenario: Verify a successful payment
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the add to bag
    And user clicks on the cart icon in the header
    Then user validates the price details in the bag
    And User clicks on the proceed to pay
    And user validates the price details in the bag
    And User clicks on the continue to payment
    And user validates the price details in the bag
    And user selecting cod option
    And User clicks on the place order button
    And User validate that the order is placed successfully

  @smoke @sanity @regression
  Scenario: Verify navigation to the successful order summary page
    Then user validates the successful order summary
    Then user clicks on the Continue Shopping button

  @smoke @sanity @regression
  Scenario: Failed Order Placement
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the add to bag
    And user clicks on the cart icon in the header
    Then user validates the price details in the bag
    And User clicks on the proceed to pay
    And user validates the price details in the bag
    And User clicks on the continue to payment
    And user validates the price details in the bag
    And user selecting UPI option
    And user enters the UPI id
    And user validates that UPI id
    And User validate that an error message indicating payment failure

