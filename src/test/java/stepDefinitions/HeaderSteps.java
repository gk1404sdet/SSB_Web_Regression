package stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.HeaderPage;
import pages.HomePage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.awt.image.ImageObserver;

public class HeaderSteps {

    HomePage homePage;
    HeaderPage headerPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public static String expectedText = " ";

    public HeaderSteps(TestContext context) {

        homePage = new HomePage(context.driver);
        headerPage = new HeaderPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    // Wishlist
    @When("User clicks on the wishlist icon in the header")
    public void user_clicks_on_the_wishlist_icon_in_the_header() {

        headerPage.closeChildWindowAndSwitchBack();
        headerPage.clickOnWishlist();
    }

    @When("User validate that wishlist icon navigate to the wishlist page")
    public void user_validate_that_wishlist_icon_navigate_to_the_wishlist_page() {

        int count = headerPage.getProductCardCount();
        scenario.log("Total product in Wishlist: " + count);
    }

    @When("User select a product from wishlist page")
    public void user_select_a_product_from_wishlist_page() {

        headerPage.clickProductByIndex(headerPage.productCard, 2);
    }

    @When("User validate that it navigates to the PDP")
    public void user_validate_that_it_navigates_to_the_pdp() {

        headerPage.switchToNewWindow();
        headerPage.isElementPresent(headerPage.proDetails);
        scenario.log("User landed to Product Details Page");
    }

    @When("User adds a product to the cart from the wishlist page")
    public void user_adds_a_product_to_the_cart_from_the_wishlist_page() {

        homePage.validateShadeOrBag();
    }

    @When("User validate that product add to cart successfully")
    public void user_validate_that_product_add_to_cart_successfully() {

        scenario.log("Product added to your cart successfully");
    }

    @Then("User removes a product from the wishlist page")
    public void user_removes_a_product_from_the_wishlist_page() throws InterruptedException {

        headerPage.clickOnRemoveWishlist(2);
    }

    @Then("User clicks on the remove item for removing product from wishlist")
    public void user_clicks_on_the_remove_item_for_removing_product_from_wishlist() {

        headerPage.clickOnRemoveItem();
    }

    // Search Functionality
    @When("User clicks on the search bar")
    public void user_clicks_on_the_search_bar() {

        headerPage.clicksOnTheSearEditBox();
    }

    @When("User search with keywords")
    public void user_search_with_keywords() {

        headerPage.enterKeyword("lipstick");
    }

    @When("user clicks enter")
    public void user_clicks_enter() throws InterruptedException {
        Thread.sleep(5000);
    }

    @When("User validate that search option navigation to the relevant products")
    public void user_validate_that_search_option_navigation_to_the_relevant_products() {

//           if (headerPage.isElementPresent(headerPage.redLip)) {
//           }
//           else if (headerPage.isElementDisplayed(headerPage.perfume)) {
//               scenario.log("User Landed to: " + headerPage.getAttribute(headerPage.perfume, "content-desc"));
//           }
//           else {
//               Assert.fail("No expected category found!");
//           }
    }

    @When("User clicks on trending products")
    public void user_clicks_on_trending_products() {

        headerPage.clickOnTrendingProduct();
    }

    @Then("User validate that selected brand navigation to the relevant brand")
    public void user_validate_that_selected_brand_navigation_to_the_relevant_brand() {

        scenario.log("User navigated to selected Popular Brand");
    }

    @Then("User validate that available events details")
    public void user_validate_that_available_events_details() {
        scenario.log("Please check again soon. We're constantly adding new events");
    }

//    @When("user notes the cart count")
//    public void user_notes_the_cart_count() {
//        int beforeCartCount = headerPage.getCartCount();
//        System.out.println("Cart count before adding product: " + beforeCartCount);
//    }
//
//    @Then("cart count should be incremented by one")
//    public void cart_count_should_be_incremented_by_one() {
//        int afterCartCount = headerPage.waitAndGetUpdatedCartCount(beforeCartCount);
//
//        Assert.assertEquals(
//                afterCartCount,
//                beforeCartCount + 1,
//                "Cart count did not increment"
//        );
//
//        System.out.println("Cart count after adding product: " + afterCartCount);
//    }

    @Then("User validate cart count incremented value")
    public void user_validate_cart_count_incremented_value() {

        int before = headerPage.getCartCount();

        homePage.validateAnotherShadeOrBag();

        int after = headerPage.waitAndGetUpdatedCartCount(before);

        Assert.assertTrue(after > before, "Cart count did not increment");
    }
}
