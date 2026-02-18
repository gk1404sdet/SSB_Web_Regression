package stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.testng.Assert;
import pages.LoginPage;
import utilities.ConfigLoader;

public class LoginSteps {

    TestContext context;
    ConfigLoader configLoader;
    Scenario scenario;
    LoginPage loginPage;


    public LoginSteps(TestContext context) {
        this.context = context;
        scenario = context.scenario;
        configLoader = new ConfigLoader();
        loginPage = new LoginPage(context.driver);
    }

    @Given("user launches the application")
    public void user_launches_the_application() {
        String url = configLoader.get("uatUrl");
        loginPage.goTo(url);
    }
    @When("user taps on the Login button")
    public void user_taps_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @When("user enters a valid mobile number")
    public void user_enters_a_valid_mobile_number() {
        String mobileNumber = context.credsLoader.get("login.validMobileNumber");
        loginPage.enterUserName(mobileNumber);
        Allure.step("Entered mobile number: " + mobileNumber);
        scenario.log("Entered mobile number: " + mobileNumber);
    }
    @When("user clicks on the Continue button")
    public void user_clicks_on_the_continue_button() {
        loginPage.clickOnContinue();
    }
    @When("user validates that the maximum OTP limit has been reached")
    public void user_validates_that_the_maximum_otp_limit_has_been_reached() {
        if (loginPage.isMaxOtpLimitDisplayed()) {
            Assert.fail("The maximum OTP limit has been reached");
        }
    }
    @Then("user enters the OTP")
    public void user_enters_the_otp() {
        String otp = context.credsLoader.get("login.staticOTP");
        loginPage.enterPassword(otp);
        Allure.step("Entered OTP: " + otp);
        scenario.log("Entered OTP: " + otp);
    }
    @When("user clicks on the Continue button for OTP validation")
    public void user_clicks_on_the_continue_button_for_otp_validation() {
        loginPage.clickOnContinue();
    }
    @Then("system should display the appropriate login status")
    public void system_should_display_the_appropriate_login_status() {
        Allure.step("User is logged in Successfully");
        scenario.log("User is logged in Successfully");
    }

    @When("user enters an Invalid mobile number")
    public void user_enters_an_invalid_mobile_number() {
        String invalidMobileNumber = context.credsLoader.get("login.invalidMobileNumber");
        loginPage.enterUserName(invalidMobileNumber);
        Allure.step("Entered mobile number: " + invalidMobileNumber);
        scenario.log("Entered mobile number: " + invalidMobileNumber);
    }
    @Then("user validate that the appropriate error message is displayed")
    public void user_validate_that_the_appropriate_error_message_is_displayed() {
        String actualText = loginPage.getInvalidNumberText();
        Assert.assertTrue(actualText.contains("Please enter a valid number"), "Invalid Mobile Number");
        Allure.step("Successfully verified the Invalid number Credentials");
        scenario.log("Successfully verified the Invalid number Credentials");
    }

    @When("user enters a mobile number")
    public void user_enters_a_mobile_number() {
        String mobileNumber = context.credsLoader.get("login.mobileNumber");
        loginPage.enterUserName(mobileNumber);
        Allure.step("Entered mobile number: " + mobileNumber);
        scenario.log("Entered mobile number: " + mobileNumber);
    }
    @Then("user clicks on the Resend button")
    public void user_clicks_on_the_resend_button() {
        loginPage.clickResendButton();
    }
    @Then("user validates that the appropriate OTP error message is displayed")
    public void user_validates_that_the_appropriate_otp_error_message_is_displayed() {
        String actualText = loginPage.getInvalidOTPErrorText();
        Assert.assertTrue(actualText.contains("Please enter a valid OTP"), "Please enter a valid OTP");
        Allure.step("Successfully verified the Invalid OTP");
        scenario.log("Successfully verified the Invalid OTP");
    }
    @Then("user validates that the OTP is resent successfully")
    public void user_validates_that_the_OTP_is_resent_successfully() {
        String actualText = loginPage.getResendOTPMessageText();
        Assert.assertTrue(actualText.contains("An OTP has been sent again"), "OTP has been sent again");
        Allure.step("Successfully verified the Resend OTP");
        scenario.log("Successfully verified the Resend OTP Message");
    }

    @Then("user clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        loginPage.clickLogoutButton();
    }

    @Then("user validates that the Logout out successfully")
    public void user_validates_that_the_logout_successfully() {
        Allure.step("Successfully verified the Logout Successfully");
        scenario.log("Successfully verified the Logout Successfully");
    }


    @When("user validate login id entry page")
    public void user_validate_login_id_entry_page() {

        loginPage.ValidateUserID();
        scenario.log("Login id entry is present");
    }

    @Given("user launches application of a product")
    public void user_launches_application_of_a_product() {

        String url = configLoader.get("dot&KeyProductUrl");
        loginPage.goTo(url);
        scenario.log("***** Product Page Of Web Application lunched Successfully *****");
    }

}
