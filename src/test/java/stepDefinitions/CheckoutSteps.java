package stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.HomePage;

import java.util.Map;


public class CheckoutSteps {

    TestContext context;
    Scenario scenario;
    HomePage homePage;
    CheckoutPage checkoutPage;

    public CheckoutSteps(TestContext context) {
        this.context = context;
        scenario = context.scenario;
        homePage = context.homePage;
        checkoutPage = new CheckoutPage(context.driver);
    }


    @When("user hovers over the categories")
    public void user_hovers_over_the_categories() {
        homePage.moveToCategories();
    }
    @When("user clicks on Concealers")
    public void user_clicks_on_concealers() {
        homePage.clickConcealers();
    }
    @When("user validates that the product does not display {string}")
    public void user_validates_that_the_product_does_not_display(String string) {

    }
    @When("user clicks on Select Shade")
    public void user_clicks_on_select_shade() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects the shade from the pop-up")
    public void user_selects_the_shade_from_the_pop_up() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks on the Add to Bag button")
    public void user_clicks_on_the_add_to_bag_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user validates that the product is successfully added to the cart")
    public void user_validates_that_the_product_is_successfully_added_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user validates the cart page navigation")
    public void user_validates_the_cart_page_navigation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks on the Proceed to Checkout button")
    public void user_clicks_on_the_proceed_to_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user validates the address page navigation")
    public void user_validates_the_address_page_navigation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {

        homePage.closeChildWindowAndSwitchBack();
        homePage.clickOnHomeButton(2);
        scenario.log("User is on Home Page");
    }

    @When("user selects a makeup category from home page")
    public void user_selects_a_makeup_category_from_home_page() {

        homePage.clickOnMakeUp();
    }

    @When("user clicks the sub category from makeup page")
    public void User_clicks_the_sub_category_from_makeup_page() {

        homePage.clickOnFoundation();
    }

    @When("user selects a product from plp")
    public void user_selects_a_product_from_plp() {

        scenario.log("Product clicked successfully at index 2");
    }

    @When("User clicks on the add to bag")
    public void user_clicks_on_the_add_to_bag(){

        homePage.validateShadeOrBag();
    }

    @When("User clicks on another product add to bag")
    public void user_clicks_on_another_product_add_to_bag(){

        homePage.validateAnotherShadeOrBag();
    }

    @When("User clicks on the move to bag")
    public void user_clicks_on_the_move_to_bag(){

        homePage.validateShadeOrMoveToBag();
    }

    @When("User clicks on the view details")
    public void user_clicks_on_the_view_details(){

        homePage.validateShadeOrDetails();
    }

    @Then("user validates the price details in the bag")
    public void user_validates_the_price_details_in_the_bag() {

        Map<String, Double> priceMap = checkoutPage.getPriceDetails();

        scenario.log("MRP : ₹" + priceMap.get("MRP"));
        scenario.log("Discount : ₹" + priceMap.get("Discount"));
        scenario.log("Delivery Fee : ₹" + priceMap.get("DeliveryFee"));
        scenario.log("Total Payable : ₹" + priceMap.get("Total"));

        Assert.assertTrue(
                checkoutPage.validatePriceDetails(priceMap),
                "Price calculation mismatch"
        );
    }
    @When("User clicks on the proceed to pay")
    public void user_clicks_on_the_proceed_to_pay() throws InterruptedException {

        checkoutPage.clickOnProceedToCheckout();
    }
    @When("User clicks on the continue to payment")
    public void user_clicks_on_the_continue_to_payment() throws InterruptedException {

        checkoutPage.clickOnContinueButton();

    }
    @Then("user selecting cod option")
    public void user_selecting_cod_option() {

        checkoutPage.selectingTheCODOption();
    }
    @Then("User clicks on the place order button")
    public void user_clicks_on_the_place_order_button() {

        checkoutPage.clickOnPlaceOrder();
    }
    @Then("User validate that the order is placed successfully")
    public void user_validate_that_the_order_is_placed_successfully() throws InterruptedException {

        checkoutPage.waitForPresenceOfElement(checkoutPage.orderSuccess);
        Assert.assertTrue(
                checkoutPage.isElementPresent(checkoutPage.orderSuccess),
                "Order NOT placed successfully"
        );
        scenario.log("Order Placed Successfully");
    }

    // Order Summary Page
    @Given("user validates the successful order summary")
    public void user_validates_the_successful_order_summary() {

        checkoutPage.printOrderDetails();
    }
    @Then("user clicks on the Continue Shopping button")
    public void user_clicks_on_the_continue_shopping_button() {

        checkoutPage.clickOnContinueShopping();
    }

    // Invalid Placement
    @Then("user selecting UPI option")
    public void user_selecting_upi_option() {

        checkoutPage.selectingTheUPIOption();
    }
    @Then("user enters the UPI id")
    public void user_enters_the_upi_id() {

        checkoutPage.enterTheUPIId("test@upi");
    }
    @Then("user validates that UPI id")
    public void user_validates_the_upi_id() {

        checkoutPage.clickOnVerify();
    }
    @Then("User validate that an error message indicating payment failure")
    public void user_validate_that_an_error_message_indicating_payment_failure() throws InterruptedException {

        scenario.log("Payment is Failed");
    }

}
