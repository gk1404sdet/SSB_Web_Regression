package stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.testng.Assert;
import pages.WishlistPage;

import java.util.List;


public class WishlistStep {

    TestContext context;
    Scenario scenario;
    WishlistPage wishlistPage;

    public static String count;

    public WishlistStep(TestContext context) {
        this.context = context;
        this.scenario =context.scenario;
        wishlistPage = new WishlistPage(context.driver);
    }


    @When("user clicks on the wishlist icon")
    public void user_clicks_on_the_wishlist_icon() {
        wishlistPage.clickWishlist();
    }
    @Then("Validate Wishlist page")
    public void validate_wishlist_page() {
       String actualText = wishlistPage.getWishlistPageText();
       Assert.assertTrue(actualText.contains("Products Wishlisted"),"User did not landed to Wishlist Page");
        Allure.step("Verify Wishlist Page");
        scenario.log("Verify Wishlist Page");
    }
    @Then("Validate Wishlist product and count")
    public void validate_wishlist_proudct_and_count() {
        String actualText = wishlistPage.getWishlistPageText();
        Assert.assertTrue(actualText.contains("Products Wishlisted"),"User did not landed to Wishlist Page");
        Allure.step("Wishlist Product Count: " + actualText);
        scenario.log("Wishlist Product Count: " + actualText);
    }

    @When("user validates the Wishlist page and product count")
    public void user_validates_the_wishlist_page_and_product_count() {
        count = wishlistPage.getWishlistPageText();
        Assert.assertTrue(count.contains("Products Wishlisted"),"User did not landed to Wishlist Page");
        Allure.step("Wishlist product count before removing: " + count);
        scenario.log("Wishlist product count before removing: " + count);
    }
    @Then("user removes the product from the Wishlist")
    public void user_removes_the_product_from_the_wishlist() {
        wishlistPage.clickWishlistRemoveIcon();
    }
    @Then("user clicks on the Remove item button")
    public void user_clicks_on_the_remove_item_button() {
        wishlistPage.clickRemoveItem();
    }
    @Then("user validates the Wishlist product count after removing the product")
    public void user_validates_the_wishlist_product_count_after_removing_the_product() {
        count = wishlistPage.getWishlistPageText();
        Assert.assertTrue(count.contains("Products Wishlisted"),"User did not landed to Wishlist Page");
        Allure.step("Wishlist product count after removing: " + count);
        scenario.log("Wishlist product count after removing: " + count);
    }




    @When("system should display the following components on the wishlist page")
    public void system_should_display_the_following_components_on_the_wishlist_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = wishlistPage.validateWishlistComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the wishlist page!");

    }

    @When("User validates wishlist product count in wishlist page")
    public void user_validates_wishlist_product_count_in_wishlist_page() {

        int count = wishlistPage.validateWishlistedCount(1);
        scenario.log(count + " Products Wishlisted");
    }

    @When("User validates 3 wishlist product count in wishlist page")
    public void user_validates_3_wishlist_product_count_in_wishlist_page() {

        int count = wishlistPage.validateWishlistedCount(3);
        scenario.log(count + " Products Wishlisted");
    }

    @When("user validates product remove x mark in wishlist page")
    public void user_validates_product_remove_x_mark_in_wishlist_page() {

        wishlistPage.validateProductToRemoveWishlist();
        scenario.log("Product remove x is present");
    }

    @When("User adds multiple products to wishlist in PLP")
    public void user_adds_multiple_products_to_wishlist_in_PLP() {

        int count = wishlistPage.addProductsToWishlist(18);
        scenario.log(count + " Products Wishlisted");
    }

    @When("User clicks on the add to favourite in PDP")
    public void user_clicks_on_the_add_to_favourite_in_PDP(){

        wishlistPage.clickOnAddToWishlistPDP();
    }

    @When("User clicks on the share icon in PDP")
    public void user_clicks_on_the_share_icon_in_PDP(){

        wishlistPage.clickOnShareIconPDP();
    }

    @When("User deletes wishlisted products from wishlist page")
    public void user_deletes_wishlisted_products_from_wishlist_page(){

        wishlistPage.removeAllProductsFromWishlist();
        scenario.log("Found no products/All products removed from wishlisted");
    }

}
