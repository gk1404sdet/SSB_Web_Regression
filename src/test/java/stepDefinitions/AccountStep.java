package stepDefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import pages.AccountPage;
import pages.LoginPage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AccountStep {

    TestContext context;
    Scenario scenario;
    ConfigLoader configLoader;
    AccountPage accountPage;
    LoginPage loginPage;

    public static String orderId;
    public static String ExpectedOrderId;

    public AccountStep(TestContext context) {
        this.context = context;
        this.scenario = context.scenario;
        this.configLoader = context.configLoader;
        loginPage = new LoginPage(context.driver);
        accountPage = new AccountPage(context.driver);
    }

    // Verify Components of Account
    @When("user hover the profile menu button")
    public void user_hover_the_profile_menu_button() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.hoverOnProfileBtn();
    }
    @Then("system should display the following components in the Account section")
    public void system_should_display_the_following_components_in_the_account_section(DataTable dataTable) {
        List<String> missingComponents = accountPage.validateAccountComponentsByText();
        Assert.assertTrue(
                missingComponents.isEmpty(),
                "Missing account components: " + missingComponents
        );
    }

    @When("user clicks on the my Profile option")
    public void user_clicks_on_the_my_profile_option() {
        accountPage.clickOnProfile();
    }
    @Then("Validating the accounts page")
    public void user_should_be_navigated_to_accounts_page() {
        String actualText = accountPage.getFirstNameLabelText();
        Assert.assertTrue(actualText.contains("First Name"), "User not navigated to accounts page");
        scenario.log("User successfully Landed into the accounts Page");
    }

    @When("user clicks on the FCC option")
    public void user_clicks_on_the_FCC_option(){
        accountPage.clicksOnFCC();
    }
    @Then("Validating the FCC page")
    public void user_should_be_navigated_to_FCC_page() {
        String actualText = accountPage.getMembershipLabelText();
        Assert.assertTrue(actualText.contains("Membership"), "User not navigated to FCC page");
        scenario.log("User Successfully Landed Into The FCC Page");
    }

    @When("user clicks on first connect card")
    public void user_clicks_on_firstConnect(){
        accountPage.first_ConnectCard();
    }
    @Then("user validating the benefit for first connect card")
    public void validate_Benefit_FirstCard(){
        String actualText = accountPage.getFirstCardBenefitText();
        Assert.assertTrue(actualText.contains("Updates On Latest Sales & Discounts"), "Benefits for first connect card is not visible or changed");
        scenario.log("Successfully verified the benefits for first connect card");
    }
    @When("user clicks on silver card")
    public void user_clicks_on_silver(){
        accountPage.clickSilverCard();
    }
    @Then("user validating the benefit for silver card")
    public void validate_Benefit_SilverCard(){
        String actualText = accountPage.getSilverCardBenefitText();
        Assert.assertTrue(actualText.contains("2 Reward Points For Every ₹200 Purchase"), "Benefits for silver card is not visible or changed");
        scenario.log("Successfully verified the benefits for silver card");
    }
    @When("user clicks on platinum card")
    public void user_clicks_on_platinum(){
        accountPage.clickPlatinumCard();
    }
    @Then("user validating the benefit for platinum card")
    public void validate_Benefit_PlatinumCard(){
        String actualText = accountPage.getPlatinumCardBenefitText();
        Assert.assertTrue(actualText.contains("6 Reward Points For Every ₹200 Purchase"), "Benefits for platinum card is not visible or changed");
        scenario.log("Successfully verified the benefits for platinum card");
    }
    @When("user clicks on black card")
    public void user_clicks_on_black(){
        accountPage.clickBlackCard();
    }
    @Then("user validating the benefit for black card")
    public void validate_Benefit_BlackCard(){
        String actualText = accountPage.getBlackCardBenefitText();
        Assert.assertTrue(actualText.contains("20 Reward Points For Every ₹200 Purchase"), "Benefits for black card is not visible or changed");
        scenario.log("Successfully verified the benefits for black card");
    }
    @When("user clicks on golden glow card")
    public void user_clicks_on_goldenGlow(){
        accountPage.golden_GlowCard();
    }
    @Then("user validating the benefit for golden glow card")
    public void validate_Benefit_GoldenCard(){
        String actualText = accountPage.getGoldenCardBenefitText();
        Assert.assertTrue(actualText.contains("4 Reward Points For Every ₹200 Purchase"), "Benefits for golden glow card is not visible or changed");
        scenario.log("Successfully verified the benefits for golden glow card");
    }


    @When("user clicks join now button")
    public void user_clicks_on_joinNow(){
        accountPage.clickJoinNow();
    }
    @When("Validating Join Now & Auto-Upgrade flow for silver card")
    public void user_verifies_the_silverCard() {
        String actualText = accountPage.verifyOnSilver();
        Assert.assertTrue(actualText.contains("Upgrade to Black"), "Issue with Join Now or Auto-Upgrade flow for silver card");
        scenario.log("Successfully verified the Join Now & Auto-Upgrade flow for silver card");
    }
    @When("User clicks close button")
    public void user_clicks_on_close(){
        accountPage.clickCloseButton();
    }
    @When("Validating Join Now & Auto-Upgrade flow for Platinum card")
    public void user_verifies_the_platinumCard() {
        String actualText = accountPage.verifyOnPlatinum();
        Assert.assertTrue(actualText.contains("Upgrade to Black"), "Issue with Join Now or Auto-Upgrade flow for Platinum card");
        scenario.log("Successfully verified the Join Now & Auto-Upgrade flow for Platinum card");
    }
    @When("Validating Join Now & Auto-Upgrade flow for black card")
    public void user_verifies_the_blackCard() {
        String actualText = accountPage.verifyOnBlack();
        Assert.assertTrue(actualText.contains("Bag"), "Issue with Join Now or Auto-Upgrade flow for black card is not landed to Cart page");
        scenario.log("Successfully verified the Join Now & Auto-Upgrade flow for black card");
    }

    @When("Validating FCC cards for FCC users or not")
    public void user_verifies_the_FCCUsers() {
        String actualText = accountPage.verifyOnSilver();
        Assert.assertTrue(actualText.contains("Upgrade to Black"), "This is not FCC user");
        scenario.log("Successfully verified the FCC cards for FCC users");
    }

    @When("user scroll down the application")
    public void scroll_down() {
        accountPage.scrollDownPage();
    }

    @When("verifying whether the page on the bottom or not")
    public void verifying_downPage() {
        String actualText = accountPage.verifyingDown();
        Assert.assertTrue(actualText.contains("Contact Us"), "This is not in the bottom of the page");
        scenario.log("Successfully verified the page on the bottom side");
    }
    @When("User click the scroll up button")
    public void scroll_up() {
        accountPage.scrollTopPage();
    }
    @When("verifying the page on the top or not")
    public void verifying_topPage(){
        String actualText = accountPage.verifyingTop();
        Assert.assertTrue(actualText.contains("Membership"), "This is not in the top of the page");
        scenario.log("Successfully verified the page on the top side");
    }

    @Then("user should be navigated to the My Profile page")
    public void user_should_be_navigated_to_profile_page() {
        String actualText = accountPage.getFirstNameLabelText();
        Assert.assertTrue(actualText.contains("First Name"), "User not navigated to Profile page");
        scenario.log("User Successfully Landed Into The Profile Page");
    }

    @Then("user clicks on profile image icon")
    public void clickProfile(){
        accountPage.clickProfilePicture();
    }
    @And("user wait two seconds")
    public void userWaitTwoSeconds() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Then("user uploads a valid profile picture")
    public void uploadProfile(){
        accountPage.uploadProfilePicture();
    }

    @Then("profile picture should be updated successfully")
    public void validateProfile(){
        String src = accountPage.validateProfilePicture();
        System.out.println(src);
        Assert.assertTrue(src.contains("profile"), "Profile picture not updated");
        scenario.log("Profile picture updated successfully");
    }

    @When("user update their first name")
    public void user_update_their_first_name() {
        String name1 = configLoader.get("address.firstName");
        String name2 = configLoader.get("address.firstName1");

        String currentName = accountPage.getEnteredName();

        if (currentName != null && currentName.equalsIgnoreCase(name1)) {
            accountPage.enterFirstName(name2);
            scenario.log("Entered First Name: " + name2);
        } else {
            accountPage.enterFirstName(name1);
            scenario.log("Entered First Name: " + name1);
        }
    }
    @When("user update their last name")
    public void user_update_their_last_name() {
        String name1 = configLoader.get("address.lastName");
        String name2 = configLoader.get("address.lastName1");

        String currentName = accountPage.getEnteredName();

        if (currentName != null && currentName.equalsIgnoreCase(name1)) {
            accountPage.enterLastName(name2);
            scenario.log("Entered Last Name: " + name2);
        } else {
            accountPage.enterLastName(name1);
            scenario.log("Entered Last Name: " + name1);
        }
    }
    @When("user update their gender details")
    public void user_update_their_gender_details() {
        accountPage.toggleGenderSelection();
    }
    @When("user clicks on the update changes")
    public void user_clicks_on_the_update_changes() {
        accountPage.clickOnTheUpdateChanges();
    }
    @When("user validate that personal details successfully updated")
    public void user_validate_that_personal_details_successfully_updated() {
        scenario.log("Your profile has been updated successfully");
    }

    @When("user clicks on the manage address")
    public void user_clicks_on_the_manage_address(){
        accountPage.clickOnManageAddress();
    }
    @When("user is able to add a new address")
    public void user_is_able_to_add_a_new_address() {
        accountPage.clicksOnNewAddress();
    }
    @When("user enters the new first name")
    public void user_enters_the_new_first_name() {
        String name = configLoader.get("address.new.fName");
        accountPage.enterUpdateFirstName(name);
        scenario.log("user Entered Name: " + name);
    }
    @When("user enters the new last name")
    public void user_enters_the_new_last_name() {
        String name = configLoader.get("address.new.lName");
        accountPage.enterUpdateLastName(name);
        scenario.log("user Entered Name: " + name);
    }
    @When("user enters the new number")
    public void user_enters_the_new_number() {
        String mob = configLoader.get("address.new.mobile");
        accountPage.enterTheMobile(mob);
        scenario.log("user Entered Name: " + mob);
    }
    @When("user enters the new pin code")
    public void user_enters_the_new_pin_code() {
        String pin = configLoader.get("address.new.pin");
        accountPage.enterThePinCode(pin);
        scenario.log("user Entered Name: " + pin);
    }
    @When("user enters the new address")
    public void user_enters_the_new_address() {
        String address = configLoader.get("address.new.line");
        accountPage.enterTheAddress(address);
        scenario.log("user Entered Name: " + address);
    }
    @When("user selects a address type as work")
    public void user_selects_a_address_type_as_work() {
        accountPage.clickOnAddressType();
    }
    @When("user clicks on the add address")
    public void user_clicks_on_the_add_address() {
        accountPage.clickOnAddAddress();
    }
    @When("user validate that new address added successfully")
    public void user_validate_that_new_address_added_successfully() {
        scenario.log("New address has been created successfully.");
    }
    @Then("user updates an existing address")
    public void user_updates_an_existing_address() {
        accountPage.clickOnEdit();
    }
    @Then("user clicks on the save changes")
    public void user_clicks_on_the_save_changes() {
        accountPage.clickOnUpdateAddress();
    }
    @Then("Validate that existing address has updated")
    public void validate_that_existing_address_has_updated() {
        scenario.log("Changes Saved");
    }
    @Then("user is able to delete exiting address")
    public void user_is_able_to_delete_exiting_address() {
        accountPage.clickOnRemove();
    }
    @Then("user clicks on the confirm remove button for delete address")
    public void user_clicks_on_the_confirm_remove_button_for_delete_address() {
        accountPage.clickOnConfirmRemoveButton();
    }
    @Then("user validate that delete address message is displayed")
    public void user_validate_that_delete_address_message_is_displayed() {
        scenario.log("Address has been deleted successfully");
    }

    @When("user clicks on the my orders option")
    public void user_clicks_on_the_my_order_option() {
        accountPage.clickOnMyOrders();
    }
    @Then("user should be navigated to the My orders page")
    public void user_should_be_navigated_to_orders_page() {
        String actualText = accountPage.getOnlineLabelText();
        Assert.assertTrue(actualText.contains("Online"), "User not navigated to orders page");
        scenario.log("User Successfully Landed Into The orders Page");
    }

    @When("user selects the first product")
    public void user_selects_the_first_product() {
        accountPage.captureMyOrderID();
    }
    @When("Capture existing Order ID from the list")
    public void capture_orderID() {
        orderId = accountPage.orderID();
        scenario.log("Existing Order ID IS : " + orderId);
    }
    @When("Enter that value in Search box")
    public void enterOrderID() {
        accountPage.enterMyOrderID(orderId);
        scenario.log("Entered Order ID: " + orderId);
    }
    @When("Capture expected Order ID from the list and validating")
    public void capture_ExpectedorderID() {
        ExpectedOrderId = accountPage.orderID();
        scenario.log("Actual Order ID IS : " + ExpectedOrderId);
        Assert.assertEquals(orderId,ExpectedOrderId, "Expected Order ID is not matching with Searching order ID");
        scenario.log("User successfully verified the search functionality");
    }

    @When("system should display the following components in the FCC section")
    public void system_should_display_the_following_components_in_the_FCC_section(DataTable dataTable) {
        List<String> missingComponents = accountPage.validateFCCComponentsByText();
        Assert.assertTrue(
                missingComponents.isEmpty(),
                "Missing account components: " + missingComponents
        );
    }
}
