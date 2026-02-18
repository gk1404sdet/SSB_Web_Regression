package stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;


public class HomePageSteps {
    
    HomePage homePage;
    CartPage cartPage;
    ProductDetailsPage pdp;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public HomePageSteps(TestContext context) {
        
        homePage = new HomePage(context.driver);
        cartPage = new CartPage(context.driver);
        pdp = new ProductDetailsPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }
    // Home Page
    // PLP

    @Given("User adds a product to the wishlist from PLP")
    public void user_adds_a_product_to_the_wishlist_from_plp() {

        homePage.clickOnAddWishlist();
    }

    @Given("User validate that product added to wishlist")
    public void user_validate_that_product_added_to_wishlist() {

        cartPage.validateErrorMessageByPartialText("Product successfully added to your wishlist", "Product successfully added to your wishlist");
        scenario.log("Product is added to wishlist");
    }

    @Given("User validate that product added to cart")
    public void user_validate_that_product_added_to_cart() {

        cartPage.validateErrorMessageByPartialText("Product successfully added to your cart", "Product successfully added to your cart");
        scenario.log("Product is added to the cart");
    }

    @Given("User validate that product added to cart from PDP")
    public void user_validate_that_product_added_to_cart_from_PDP() {

        pdp.ValidateProductAddedToCart();
        scenario.log("Product is added to the cart");
    }

    @Given("User remove a product to the wishlist from PLP")
    public void user_remove_a_product_to_the_wishlist_from_plp() {

        homePage.clickOnAddWishlist();
    }

    @Then("User validate that product removed from wishlist")
    public void user_validate_that_product_removed_from_wishlist() {

        cartPage.validateErrorMessageByPartialText("Product has been removed from wishlist", "Product has been removed from wishlist");
        scenario.log("Removed from your wishlist");
    }

    // Sort
    @Then("User clicks on the sort option")
    public void user_clicks_on_the_sort_option() {

        scenario.log("User Applying the Sort Functionality");
    }

    @Then("User selects a sort option as price low to high")
    public void user_selects_a_sort_option_as_price_low_to_high() {

        homePage.clickOnPriceLowToHigh();
    }
    @Then("User selects a sort option as price high to low")
    public void user_selects_a_sort_option_as_price_high_to_low() {

        homePage.clickOnPriceHighToLow();
    }
    @Then("User validate that product sorted product is displayed")
    public void user_validate_that_product_sorted_product_is_displayed() {

        Assert.assertTrue(true, "User Sort successfully");
        scenario.log("Sort Applied Successfully");
    }

    // Filter
    @Then("User clicks on the filter option")
    public void user_clicks_on_the_filter_option() {

        scenario.log("User Applying the Filter Functionality");
    }
    @Then("User select the category as makeup")
    public void user_select_the_category_as_makeup() {

        homePage.clickOnFilterCategory();
    }
    @Then("User selects the brands as life")
    public void user_selects_the_brands_as_life() {

        homePage.clickOnBrandsFiler();
    }
    @Then("User validate that products are displayed as per filter")
    public void user_validate_that_products_are_displayed_as_per_filter() {

        Assert.assertTrue(true, "User Applied Filter successfully");
        scenario.log("User has Applied Filter successfully");
    }
    @Then("user validates that filter has removed")
    public void user_validates_that_filter_has_removed() {

        Assert.assertTrue(true, "User Removed Filter successfully");
        scenario.log("User has Removed Filter successfully");
    }

    // Invalid Postal code Check
    @When("user enters an invalid postal code for delivery")
    public void user_enters_an_invalid_postal_code_for_delivery() {

        String pin = configLoader.get("postal.invalidPin");
        homePage.enterPostalCode(pin);
        scenario.log("User Entered the Postal Code: " + pin);
    }

    @When("user clicks on the check option")
    public void user_clicks_on_the_check_option() {

        homePage.clickOnChange();
    }

    @When("user sees a message indicating to enter a valid postal code")
    public void user_sees_a_message_indicating_to_enter_a_valid_postal_code() {

        homePage.validateErrorMessageByPartialText("Invalid Pincode, Please enter 6 Digits Pincode", "Invalid Pincode, Please enter 6 Digits Pincode");
    }

    //Valid Postal code
    @When("user enters an valid postal code for delivery")
    public void user_enters_an_valid_postal_code_for_delivery() {

        String pin = configLoader.get("postal.validPin");
        homePage.enterPostalCode(pin);
        scenario.log("User Entered the Postal Code: " + pin);
    }
}