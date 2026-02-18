package stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.util.List;


public class GuestUserSteps {

    AccountPage accountPage;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;
    GuestUserPage guestUserPage;
    BasePage basePage;

    public GuestUserSteps(TestContext context) {

        homePage = new HomePage(context.driver);
        accountPage = new AccountPage(context.driver);
        loginPage = new LoginPage(context.driver);
        guestUserPage = new GuestUserPage(context.driver);
        cartPage = new CartPage(context.driver);
        basePage = new BasePage(context.driver);

        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    @Given("User validates categories from homepage")
    public void User_validates_categories_from_homepage() {

        homePage.validateErrorMessageByPartialText("Categories", "Categories");
        scenario.log("Categories is present in homepage");
    }

    @Given("User validates search from homepage")
    public void User_validates_search_from_homepage() {

        homePage.validateSearch();
        scenario.log("Search is present in homepage");
    }

    @Then("user scroll into footer and click Terms of use from homepage")
    public void user_scroll_into_footer_and_click_Terms_of_use_from_homepage() {

        guestUserPage.clickOnTermsOfUse();
        scenario.log("Scrolled to footer and Terms of use option is clicked successfully");
    }

    @Then("user validates footer from homepage")
    public void user_validates_footer_from_homepage() {

        homePage.validateErrorMessageByPartialText("TERMS & CONDITIONS", "TERMS & CONDITIONS");
        scenario.log("Terms & Conditions is present");
    }

    @Then("user enters keyword in searchBox")
    public void User_enters_keyword_in_searchBox() {

        String keyword = configLoader.get("genericKeyword");
        guestUserPage.enterKeyword(keyword);
        scenario.log("user Entered the keyword: " + keyword);
    }

    @Then("user enters selectShade product in searchBox")
    public void User_enters_selectShade_product_in_searchBox() {

        String keyword = configLoader.get("selectShadeProduct");
        guestUserPage.enterKeyword(keyword);
        scenario.log("user Entered the keyword: " + keyword);
    }

    @Then("User validates makeup label from makeup PLP")
    public void User_validates_makeup_label_from_makeup_PLP() {

        guestUserPage.validateMakeupPLP();
        scenario.log("Makeup label is present");
    }

    @Then("User validates dotAndKey label from makeup PLP")
    public void User_validates_dotAndKey_label_from_makeup_PLP() {

        guestUserPage.validateDotAndKeyPLP();
        scenario.log("Dot & Key label is present");
    }

    @Then("user clicks strip banner")
    public void user_clicks_strip_banner() {

        guestUserPage.clickOnStripBanner();
//        guestUserPage.validateTermsOfUsePage();
        scenario.log("Strip banner is clicked");
    }

    @Then("user clicks strip banner logged in user")
    public void user_clicks_strip_banner_logged_in_user() {

        guestUserPage.clickOnStripBannerLoginUser();
//        guestUserPage.validateTermsOfUsePage();
        scenario.log("Strip banner is clicked");
    }

    @Given("User switch new window")
    public void User_switch_new_window() {
        guestUserPage.switchToProductWindow();
        scenario.log("Switched to product window");
    }

    @Given("user switch window by index")
    public void user_switch_window_by_index() {
        guestUserPage.switchToWindowByIndex(2);
        scenario.log("Switched to product window");
    }

    @When("User clicks on the add to bag in PDP")
    public void user_clicks_on_the_add_to_bag_in_PDP(){

        guestUserPage.clickOnAddTCartPDP();
    }

    @When("User clicks on the price high to low from sort by")
    public void user_clicks_on_the_price_high_to_low_from_sort_by(){

        guestUserPage.clickOnHighToLowSortBy();
    }

    @When("User clicks on the price low to high from sort by")
    public void user_clicks_on_the_price_low_to_high_from_sort_by(){

        guestUserPage.clickOnLowToHighSortBy();
    }

    @When("User clicks on brand filter")
    public void user_clicks_on_brand_filter(){

        guestUserPage.clickOnBrandFilter();
    }

    @When("User clicks on categories filter")
    public void user_clicks_on_categories_filter(){

        guestUserPage.clickOnCategoriesFilter();
    }

    @When("User add first PLP product as wishlist")
    public void User_add_first_PLP_product_as_wishlist(){

        guestUserPage.clickOnFirstProductWishlist();
    }

    @When("User add product to wishlist in PDP")
    public void User_add_product_to_wishlist_in_PDP(){

        guestUserPage.clickOnWishlistInPDP();
    }

    @When("User clicks close in login page")
    public void User_clicks_close_in_login_page(){

        guestUserPage.clickOnCloseLogin();
    }

    @When("system should display the following components on the PDP page")
    public void system_should_display_the_following_components_on_the_PDP_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = guestUserPage.validatePDPComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");

    }

    @When("User selects arcelia filter from brand")
    public void user_selects_arcelia_filter_from_brand(){

        guestUserPage.clickOnArceliaBrand();
    }

    @When("User selects sugar filter from brand")
    public void user_selects_sugar_filter_from_brand(){

        guestUserPage.clickOnSugarBrand();
    }

    @When("User selects face filter from brand")
    public void user_selects_face_filter_from_brand(){

        guestUserPage.clickOnFaceBrand();
    }

    @When("User validate arcelia label from filtered brand")
    public void user_validate_arcelia_label_from_filtered_brand(){

        homePage.validateErrorMessageByPartialText("Arcelia", "Arcelia");
        scenario.log("Arcelia label is present");
    }

    @When("User validate face label from filtered brand")
    public void user_validate_face_label_from_filtered_brand(){

        homePage.validateErrorMessageByPartialText("Face", "Face");
        scenario.log("Switched to product window");
    }

    @When("User validate sugar label from filtered brand")
    public void user_validate_sugar_label_from_filtered_brand(){

        homePage.validateErrorMessageByPartialText("SUGAR", "SUGAR");
        scenario.log("Switched to product window");
    }

    @When("Validate high to low price in sort by")
    public void validate_high_to_low_price_in_sort_by(){

        guestUserPage.validateHighToLowSortBy();
        scenario.log("The product prices are from high to low.");
    }

    @When("Validate low to high price in sort by")
    public void validate_low_to_high_price_in_sort_by(){

        guestUserPage.validateLowToHighSortBy();
        scenario.log("The product prices are from low to high.");
    }

    @When("user validates product remove x mark")
    public void user_validates_product_remove_x_mark() {

        cartPage.validateProductToRemove();
        scenario.log("Product remove x is present");
    }

    @When("user validates products sort by")
    public void user_validates_products_sort_by() {

        homePage.validateErrorMessageByPartialText("Sort By", "Sort By");
        scenario.log("Product Sort By is present");
    }

    @When("User validate the product count in cart")
    public void user_validate_the_product_count_in_cart() {

        guestUserPage.validateProductCount(2);
        scenario.log("Product count is matched in cart");
    }

    @When("User validate the product count in cart as 1")
    public void user_validate_the_product_count_in_cart_as_1() {

        guestUserPage.validateProductCount(1);
        scenario.log("Product count is matched in cart");
    }

    @When("User validate the products in cart")
    public void user_validate_the_products_in_cart() {

//        guestUserPage.validateLakMeSkinNaturalMousseTitle();
        homePage.validateErrorMessageByPartialText("Absolute Mattreal Skin Natural Mousse", "Absolute Mattreal Skin Natural Mousse");
//        guestUserPage.validateNarSLongWearFoundationTitle();
        homePage.validateErrorMessageByPartialText("Natural Radiant Longwear Foundation - Namibia, 30 ml", "Natural Radiant Longwear Foundation - Namibia, 30 ml");
        scenario.log("Products present in cart");
    }

    @When("User validate the product in cart")
    public void user_validate_the_product_in_cart() {

//        guestUserPage.validateLakMeSkinNaturalMousseTitle();
        homePage.validateErrorMessageByPartialText("Absolute Mattreal Skin Natural Mousse", "Absolute Mattreal Skin Natural Mousse");
        scenario.log("Product present in cart");
    }

}
