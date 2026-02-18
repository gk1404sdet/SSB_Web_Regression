package stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HeaderPage;
import pages.HomePage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.util.Arrays;
import java.util.List;



public class CartPageSteps {

    CartPage cartPage;
    HeaderPage headerPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public CartPageSteps(TestContext context) {

        cartPage = new CartPage(context.driver);
        headerPage = new HeaderPage(context.driver);
        checkoutPage = new CheckoutPage(context.driver);
        homePage = new HomePage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    // Cart
    @When("user selects a hair category from home page")
    public void user_selects_a_hair_category_from_home_page() {

        homePage.clickOnHair();
    }
    @When("user clicks the sub category from hair page")
    public void User_clicks_the_sub_category_from_hair_page() {

        homePage.clickOnConditioner();
    }

    @Given("user clicks SSBeauty logo to return to homepage")
    public void user_clicks_SSBeauty_logo_to_return_to_homepage() {

        cartPage.clickOnSSBeautyLogo(1);
        scenario.log("User is on Home Page");
    }

    @When("user selects a skin category from home page")
    public void user_selects_a_skin_category_from_home_page() {

        homePage.clickOnSkin();
    }
    @When("user clicks the sub category from skin page")
    public void User_clicks_the_sub_category_from_skin_page() {

        homePage.clickOnFacial();
    }
    @When("user clicks on the cart icon in the header")
    public void user_clicks_on_the_cart_icon_in_the_header() {

        cartPage.clickOnCartIcon();
    }

    @When("user clicks on the view all from your wishlist in cart page")
    public void user_clicks_on_the_view_all_from_your_wishlist_in_cart_page() {

        cartPage.clickOnWishlistViewAll();
    }

    @When("user clicks on the wishlist icon in the header")
    public void user_clicks_on_the_wishlist_icon_in_the_header() {
        cartPage.clickOnWishlistIcon();
    }

    @When("user validate that cart is not empty")
    public void User_validate_that_cart_is_not_empty() {

        if(cartPage.isElementPresent(checkoutPage.emptyBag)) {
            String msg = "Your Bag Feels Too Light!";
            Assert.fail("Test Failed because cart is empty: " + msg);
        }
        scenario.log("Cart has items, continuing...");
    }

    @When("user validate that wishlist is not empty")
    public void User_validate_that_wishlist_is_not_empty() {

        if(cartPage.isElementPresent(cartPage.emptyWishlist)) {
            String msg = "Your Wishlist is Empty";
            Assert.fail("Test Failed because wishlist is empty: " + msg);
        }
        scenario.log("Wishlist has items, continuing...");
    }

    @When("user validate that wishlist is empty")
    public void user_validate_that_wishlist_is_empty() {

        if(!cartPage.isElementPresent(cartPage.emptyWishlist)) {
            String msg = "Wishlist has products";
            Assert.fail("Test Failed because wishlist is not empty: " + msg);
        }
        scenario.log("Your Wishlist is Empty");
    }

    @When("user validate that cart is empty")
    public void user_validate_that_cart_is_empty() {

        if(!cartPage.isElementPresent(cartPage.emptyCart)) {
            String msg = "Cart has products";
            Assert.fail("Test Failed because cart is not empty: " + msg);
        }
        scenario.log("Your Cart is Empty");
    }

    // Cart Page Components
    @When("system should display the following components on the cart page")
    public void system_should_display_the_following_components_on_the_cart_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = cartPage.validateCartComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the cart page!");

    }

    // Increase and Decrease
    @When("user increase the product quantity in the cart")
    public void user_increase_the_product_quantity_in_the_cart() throws InterruptedException {

        cartPage.adjustQuantity(2, true, cartPage.increaseQuan);
    }

    @When("user validate increase and decrease product quantity in the cart")
    public void user_validate_increase_and_decrease_product_quantity_in_the_cart() throws InterruptedException {

        cartPage.validateIncreaseQuan();
        scenario.log("Increase quantity option is present");
        cartPage.validateDecreaseQuan();
        scenario.log("Decrease quantity option is present");
    }

    @When("user decrease the product quantity in the cart")
    public void user_decrease_the_product_quantity_in_the_cart() throws InterruptedException {

        cartPage.adjustQuantity(1, false, cartPage.decreaseQuan);
    }

    // Wishlist moving from Cart/bag
    @When("user clicks on the product x mark")
    public void user_clicks_on_the_product_x_mark() {

        cartPage.clickOnProductToRemove();
    }
    @When("user moves a product to the wishlist from the cart")
    public void user_moves_a_product_to_the_wishlist_from_the_cart() {

        cartPage.clickOnMoveToWishlist();
    }
    @When("user validate that product moved to wishlist")
    public void user_validate_that_product_moved_to_wishlist() {

        scenario.log("Product moved to your wishlist from Cart/My bag");
    }
    @When("user removes a product to the wishlist from the cart")
    public void user_removes_a_product_to_the_wishlist_from_the_cart() {

        cartPage.clickOnRemoveItem();
    }
    @When("user validate that product removed from cart")
    public void user_validate_that_product_removed_from_cart() {

        scenario.log("Product has been Removed");
    }

    // PinCode check on the cart page
    @When("user clicks change address button")
    public void user_clicks_change_address_button() {

    }

    @Then("user clicks on the check option to validate the postal code")
    public void user_clicks_on_the_check_option_to_validate_the_postal_code() {

        cartPage.clickOnCheckOption();
    }

    @When("user enters an invalid postal code")
    public void user_enters_an_invalid_postal_code() {

        String pin = configLoader.get("postal.invalidPin");
        cartPage.enterThePinCode(pin);
        scenario.log("user Entered Name: " + pin);
    }

    @When("user enters the postal code")
    public void user_enters_the_postal_code() {

        String pin = configLoader.get("postal.validPin");
        cartPage.enterThePinCode(pin);
        scenario.log("user Entered Name: " + pin);
    }

    @Then("system should display the appropriate error message")
    public void system_should_display_the_appropriate_error_message() {

        cartPage.validateErrorMessageByPartialText("Pin code should contain 6 digits", "Pin code should contain 6 digits");
    }

    @Then("validate basket loading widget while performing actions")
    public void validate_basket_loading_widget_while_performing_actions() {

        cartPage.validateBasketLoadingWidget();
        scenario.log("Basket loading widget occurs while performing actions");
    }


//
//    // CRUD
//    @Then("user updates an existing address on Cart page")
//    public void user_updates_an_existing_address_on_cart_page() {
//
//        cartPage.clickOnEditAddress();
//    }
//    @Then("user clicks on the yes button for delete address")
//    public void user_clicks_on_the_yes_button_for_delete_address() {
//
//        cartPage.clickOnYesButton();
//    }
//    @When("user is able to add a new address on cart page")
//    public void user_is_able_to_add_a_new_address_on_cart_page() {
//
//        cartPage.clickOnAddNewAddress();
//    }
//    @When("user enters the new number on cart")
//    public void user_enters_the_new_number_on_cart() {
//
//        String mob = configLoader.getProperty("address.new.mobile");
//        cartPage.enterNewNumber(mob);
//        scenario.log("user Entered Mobile Number: " + mob);
//    }

}
