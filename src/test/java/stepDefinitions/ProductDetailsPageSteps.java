package stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.util.List;
import java.util.Map;

public class ProductDetailsPageSteps {

    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    WishlistPage wishlistPage;
    GuestUserPage guestUserPage;
    ProductDetailsPage pdp;
    Scenario scenario;

    public ProductDetailsPageSteps(TestContext context) {

        homePage = new HomePage(context.driver);
        accountPage = new AccountPage(context.driver);
        loginPage = new LoginPage(context.driver);
        guestUserPage = new GuestUserPage(context.driver);
        wishlistPage = new WishlistPage(context.driver);
        pdp = new ProductDetailsPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    private String productNamePDP;
    private String firstProductNameCart;
    private String firstProductQuantityCountBefore;
    private String firstProductQuantityCountAfterIncrement;
    private String firstProductQuantityCountAfterDecrement;
    private String firstProductNamePLP;
    private String productNamePDPTrimmedVersion;


    @When("system should display the following components on the share options page")
    public void system_should_display_the_following_components_on_the_share_options_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = pdp.validateShareOptionsComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");
    }

    @When("User clicks on the view similar products icon in PDP")
    public void user_clicks_on_the_view_similar_products_icon_in_PDP(){

        pdp.clickOnViewSimilarProductsIconPDP();
    }

    @Then("validate chambor brand is present in first 4 products")
    public void validate_chambor_brand_is_present_in_first_4_products() {

        List<String> productNames = pdp.getFirstFourProductNames();
        for (String productName : productNames) {
            Assert.assertTrue(
                    productName.toLowerCase().contains("chambor"),
                    "Non-Chambor product found: " + productName
            );
            scenario.log("Validated product: " + productName);
        }
    }

    @When("User clicks on the add to bag from similar product in PDP")
    public void user_clicks_on_the_add_to_bag_from_similar_product_in_PDP(){

        pdp.clickOnAddToCartSimilarProductPDP();
    }

    @When("User clicks on the add to favourite from similar product in PDP")
    public void user_clicks_on_the_add_to_favourite_from_similar_product_in_PDP(){

        pdp.clickOnAddToFavouriteSimilarProductPDP();
    }

    @When("User clicks on the add to favourite from customers also bought in PDP")
    public void user_clicks_on_the_add_to_favourite_from_customers_also_bought_in_PDP(){

        pdp.clickOnAddToFavouriteCustomersAlsoBoughtPDP();
    }

    @When("Move to similar product from PDP and click on add to bag")
    public void move_to_similar_product_from_PDP_and_click_on_add_to_bag(){

        pdp.moveToSimilarProductPDP();
    }

    @When("Move to customers also bought from PDP and click on add to bag")
    public void move_to_customers_also_bought_from_PDP_and_click_on_add_to_bag(){

        pdp.moveToCustomersAlsoBoughtPDP();
    }

    @When("Scroll to similar products product")
    public void scroll_to_similar_products_product(){

        pdp.scrollSimilarProductsProductPDP();
    }

    @When("Scroll to customers also bought product")
    public void scroll_to_customers_also_bought_product(){

        pdp.scrollCustomersAlsoBoughtProductPDP();
    }

    @When("Scroll and click on write a review")
    public void scroll_and_click_on_write_a_review(){

        pdp.scrollToWriteAReviewPDP();
    }

    @When("system should display the following components on write a review popup")
    public void system_should_display_the_following_components_on_write_a_review_popup(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = pdp.validateWriteAReviewComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");
    }

    @When("Select ratings star from write a review popup")
    public void select_ratings_star_from_write_a_review_popup(){
        pdp.clickOnRatingsStar();
    }

    @Then("User enters review title in review title textbox")
    public void User_enters_review_title_in_review_title_textbox() {

        String keyword = configLoader.get("reviewTitle");
        pdp.enterReviewTitle(keyword);
        scenario.log("user Entered the keyword: " + keyword);
    }

    @Then("User enters review description in review title textbox")
    public void User_enters_review_description_in_review_title_textbox() {

        String keyword = configLoader.get("reviewDescription");
        pdp.enterReviewDescription(keyword);
        scenario.log("user Entered the keyword: " + keyword);
    }

    @When("Click on add review button from write a review popup")
    public void click_on_add_review_button_from_write_a_review_popup(){

        pdp.clickOnAddReviewBtn();
    }

    @When("Validate review submitted message in submitted popup")
    public void validate_review_submitted_message_in_submitted_popup(){

        homePage.validateErrorMessageByPartialText("Thanks for Sharing Your Review!", "Thanks For Sharing Your Review!");
    }

    @Then("Get Product name from PDP")
    public void Get_Product_name_from_PDP() {

        productNamePDP = pdp.getProductNamePDP();
        scenario.log("Product name from PDP: " + productNamePDP);
    }

    @Then("Get Product name from PDP trimmed version")
    public void Get_Product_name_from_PDP_trimmed_version() {

        productNamePDPTrimmedVersion = pdp.getProductNamePDPTrimmedVersion();
        scenario.log("Product name from PDP trimmed version: " + productNamePDPTrimmedVersion);
    }

    @Then("Get First Product name from PLP")
    public void Get_First_Product_name_from_PLP() {

        firstProductNamePLP = pdp.getFirstProductNamePLP();
        scenario.log("First Product name from PLP: " + firstProductNamePLP);
    }

    @Then("Get First Product name in the cart page")
    public void Get_First_Product_name_in_the_cart_page() {

        firstProductNameCart = pdp.getFirstCartProductName();
        scenario.log("First product name in the cart: " + firstProductNameCart);
    }

    @Then("Validate PDP product name and added cart product name")
    public void Validate_PDP_product_name_and_added_cart_product_name() {

        Assert.assertEquals(productNamePDP,firstProductNameCart,"Both the product name do not match");

        scenario.log("Product is Added to bag and verified in Cart page");
    }

    @Then("Validate PLP first product name and PDP product name")
    public void Validate_PLP_first_product_name_and_PDP_product_name() {


        Assert.assertTrue(firstProductNamePLP.contains(productNamePDPTrimmedVersion),"Both the product name do not match");

        scenario.log("First Product name from PLP and after clicked the product, the name from PDP are Same");
    }

    @Then("upload photo to review in PDP")
    public void upload_photo_to_review_in_PDP() {

        pdp.uploadReviewPhoto();

        scenario.log("Photo is uploaded to write a review section");
    }

    @When("system should display all trusted badges components on the PDP page")
    public void system_should_display_all_trusted_badges_components_on_the_PDP_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = pdp.validatePDPTrustedBadgesByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");

    }

    @When("system should display the following additional details on the PDP page")
    public void system_should_display_the_following_additional_details_on_the_PDP_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = pdp.validatePDPAdditionalDetailsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");

    }

    @Then("click on view more option from additional details in PDP")
    public void click_on_view_more_option_from_additional_details_in_PDP() {

        pdp.clickOnViewMoreProdDescription();

        scenario.log("view more option is clicked from additional details");
    }

    @Then("click on view less option from additional details in PDP")
    public void click_on_view_less_option_from_additional_details_in_PDP() {

        pdp.clickOnViewLessProdDescription();

        scenario.log("view less option is clicked from additional details");
    }

    @Then("click on view more option from how to use in PDP")
    public void click_on_view_more_option_from_how_to_use_in_PDP() {

        pdp.clickOnViewMoreHowtoUse();

        scenario.log("view more option is clicked from how to use");
    }

    @Then("click on view less option from how to use in PDP")
    public void click_on_view_less_option_from_how_to_use_in_PDP() {

        pdp.clickOnViewLessHowToUse();

        scenario.log("view less option is clicked from how to use");
    }

    @Then("click on view more option from about the brand in PDP")
    public void click_on_view_more_option_from_about_the_brand_in_PDP() {

        pdp.clickOnViewMoreAboutTheBrand();

        scenario.log("view more option is clicked from about the brand");
    }

    @Then("click on view less option from about the brand in PDP")
    public void click_on_view_less_option_from_about_the_brand_in_PDP() {

        pdp.clickOnViewLessAboutTheBrand();

        scenario.log("view less option is clicked from about the brand");
    }

    @Given("user launches meesho application")
    public void user_launches_meesho_application() {

//        String url = configLoader.getProperty("meesho");
//        loginPage.goTo(url);
//        scenario.log("***** Meesho Application lunched Successfully *****");
//        pdp.waitFor();
        pdp.meeshoLaunch();
    }

    @When("validate Go To Bag button from PDP")
    public void validate_Go_To_Bag_button_from_PDP(){

        homePage.validateErrorMessageByPartialText("Go To Bag", "Go To Bag");
        scenario.log("Go To Bag is present in PDP");
    }

    @When("click on Go To Bag button from PDP")
    public void click_on_Go_To_Bag_button_from_PDP(){

        pdp.clickOnGoToBagPDP();
        scenario.log("Go To Bag button is clicked");
    }

    @Then("Get First Product quantity count in the cart")
    public void Get_First_Product_quantity_count_in_the_cart() {

        firstProductQuantityCountBefore = pdp.getProductQuantityCount();
        scenario.log("First product quantity count is: " + firstProductQuantityCountBefore);
    }

    @Then("Get First Product quantity count in the cart after increment")
    public void Get_First_Product_quantity_count_in_the_cart_after_increment() {

        firstProductQuantityCountAfterIncrement = pdp.getProductQuantityCount();
        scenario.log("First product quantity count after increment is: " + firstProductQuantityCountAfterIncrement);
    }

    @Then("Get First Product quantity count in the cart after decrement")
    public void Get_First_Product_quantity_count_in_the_cart_after_decrement() {

        firstProductQuantityCountAfterDecrement = pdp.getProductQuantityCount();
        scenario.log("First product quantity count after increment is: " + firstProductQuantityCountAfterDecrement);
    }

    @When("validate increment quantity count from before count after incrementing")
    public void validate_increment_quantity_count_from_before_count_after_incrementing(){

        pdp.validateQuantityIncrementCount(firstProductQuantityCountBefore, firstProductQuantityCountAfterIncrement);
        scenario.log("After incrementing, the quantity count is " + firstProductQuantityCountAfterIncrement + " and it is validated");
    }

    @When("validate decrement quantity count from increased quantity count after decrementing")
    public void validate_decrement_quantity_count_from_increased_quantity_count_after_decrementing(){

        pdp.validateQuantityDecrementCount(firstProductQuantityCountAfterIncrement, firstProductQuantityCountAfterDecrement);
        scenario.log("After decrementing, the quantity count is " + firstProductQuantityCountAfterDecrement + " and it is validated");
    }

}
