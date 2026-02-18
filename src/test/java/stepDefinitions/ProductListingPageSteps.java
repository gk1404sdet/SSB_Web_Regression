package stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.util.List;
import java.util.Map;

public class ProductListingPageSteps {

    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    WishlistPage wishlistPage;
    ProductListingPage plp;
    Scenario scenario;

    public ProductListingPageSteps(TestContext context) {

        homePage = new HomePage(context.driver);
        accountPage = new AccountPage(context.driver);
        loginPage = new LoginPage(context.driver);
        checkoutPage = new CheckoutPage(context.driver);
        wishlistPage = new WishlistPage(context.driver);
        plp = new ProductListingPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    private String productNamePLP;
    private String productNamePLPSugarFilter;

    @Then("User validates product shade popup text")
    public void user_validates_product_shade_popup_text() {

        plp.validateShade();
        String actualText = plp.getProductShadePopupText();
        System.out.println("Shade Popup text: " + actualText);

        String shadeProductKeyword = configLoader.get("selectShadeProduct");
        Assert.assertEquals(actualText, shadeProductKeyword);
    }

    @Then("user selects product shade variant in popup")
    public void user_selects_product_shade_variant_in_popup() {

        plp.selectShadeVariant();
    }

    @Then("user verify product shade variant name in cart page")
    public void user_verify_product_shade_variant_name_in_cart_page() {

        String actualProductName = plp.cartProductName();
        System.out.println(" Product name: " + actualProductName);

        String shadeProductKeyword = configLoader.get("shadeProductcartName");
        Assert.assertEquals(actualProductName, shadeProductKeyword);
    }

    @When("system should display the following product info on the PLP product")
    public void system_should_display_the_following_product_info_on_the_PLP_product() {

        Map<String, String> productDetails =plp.validateFirstProductDetails();

        String name = productDetails.get("name");
        String price = productDetails.get("price");
        String offer = productDetails.get("offer");
        scenario.log("Product - Name: " + name);
        scenario.log("Product - Price: " + price);
        scenario.log("Product - Offer: " + offer);
    }

    @When("system should display first product offer tile info on the PLP")
    public void system_should_display_first_product_offer_tile_info_on_the_PLP() {

        Map<String, String> productDetails =plp.validateFirstProductOfferTile();

        String offerText = productDetails.get("offer");
        scenario.log("First Product - Offer: " + offerText);
    }

    @When("system should display second product offer tile info on the PLP")
    public void system_should_display_second_product_offer_tile_info_on_the_PLP() {

        Map<String, String> productDetails =plp.validateSecondProductOfferTile();

        String offerText = productDetails.get("offer");
        scenario.log("Second Product - Offer: " + offerText);
    }

    @When("Validate product count for searched keyword")
    public void validate_product_count_for_searched_keyword() {

        int actualCount = plp.getProductCount();
        scenario.log("Product count displayed: " + actualCount);
    }

    @When("User hover on product and validate options")
    public void user_hover_on_product_and_validate_options(){

        plp.validateViewDetailsAndAddToBag();
        scenario.log("View Details and Add To Bag options are visible on hover");
    }

    @Then("Get Product name from PLP")
    public void Get_Product_name_from_PDP() {

        productNamePLP = plp.getProductNamePLP();
        scenario.log("Before Filtering Product name from PLP: " + productNamePLP);
        Assert.assertFalse(
                productNamePLP.contains("Sugar"),
                "Sugar brand is unexpectedly present in PLP product name: " + productNamePLP
        );

        scenario.log("Validated Sugar brand is NOT present in PLP product name");
    }

    @Then("Get Product name from PLP after applying sugar brand filter")
    public void Get_Product_name_from_PDP_after_applying_sugar_brand_filter() {

        productNamePLPSugarFilter = plp.getProductNamePLP();
        scenario.log("After Filtering Product name from PLP: " + productNamePLPSugarFilter);
        Assert.assertTrue(
                productNamePLPSugarFilter.contains("Sugar"),
                "Product name does not contain 'Sugar': " + productNamePLPSugarFilter
        );
        scenario.log("Validated Sugar brand is present in PLP product name");
    }

    @When("Click on Clear all button on filters")
    public void click_on_Clear_all_button_on_filters(){

        plp.clickOnClearAllBtn();
    }

    @When("user validates foundations label from PLP")
    public void user_validates_foundations_label_from_PLP() {

        plp.validateFoundationsLabelPLP();
        scenario.log("Foundations label is present in PLP");
    }

    @When("user validates M.A.C Matte Lipstick - Mehr label from PLP")
    public void user_validates_MAC_Matte_Lipstick_Mehr_label_from_PLP() {

        plp.validateMacMatteLipstickMehrLabelPLP();
        scenario.log("MAC matte lipstick mehr label is present in PLP");
    }

    @Then("user enters lipstick in searchBox")
    public void User_enters_lipstick_in_searchBox() {

        String keyword = configLoader.get("lipstickKeyword");
        plp.enterKeyword(keyword);
        scenario.log("user Entered the keyword: " + keyword);
    }

    @Then("User validates lipstick label from makeup PLP")
    public void User_validates_lipstick_label_from_makeup_PLP() {

        plp.validateMakeupPLP();
        scenario.log("Makeup label is present");
    }

    @When("system should display the following components on the PLP page")
    public void system_should_display_the_following_components_on_the_PLP_page(DataTable dataTable) throws InterruptedException {

        List<String> expectedSections = dataTable.asList();
        boolean result = plp.validatePLPComponentsByText(expectedSections);
        Assert.assertTrue(result, "Some expected components are missing on the PDP page!");
    }

    @When("scroll to bottom of page and click upArrow button from PLP")
    public void scroll_to_bottom_of_page_and_click_upArrow_button_from_PLP() {

        plp.scrollToBottomPageAndClickUpArrow();
        scenario.log("upArrow is clicked and screen came to the Top");
    }

    @When("validate upArrow button is not present in the PLP")
    public void validate_upArrow_button_is_not_present_in_the_PLP() {

        boolean isVisible = plp.isUpArrowBtnVisible();
        Assert.assertFalse(isVisible, "Up Arrow button is visible, but it should NOT be visible");
        scenario.log("Validated Up Arrow button is not visible");
    }

}
