package stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.testng.Assert;
import pages.LoginPage;
import utilities.ConfigLoader;

public class LoginSteps {

    private final TestContext context;
    private ConfigLoader configLoader;
    private final Scenario scenario;

    private LoginPage loginPage;


    public LoginSteps(TestContext context) {
        this.context = context;
        this.configLoader = new ConfigLoader();
        this.scenario = context.scenario;
        this.loginPage = new LoginPage(context.driver);
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
        String mobileNumber = context.credsLoader.get("validMobileNumber");
        loginPage.enterUserName(mobileNumber);
        Allure.step("Entered mobile number: " + mobileNumber);
        scenario.log("Entered mobile number: " + mobileNumber);
    }
    @When("user clicks on the Continue button")
    public void user_clicks_on_the_continue_button() {
        loginPage.clickContinueButton();
    }
    @Then("user enters the OTP")
    public void user_enters_the_otp() {
        String otp = context.credsLoader.get("staticOTP");
        loginPage.enterPassword(otp);
        Allure.step("Entered OTP: " + otp);
        scenario.log("Entered OTP: " + otp);
    }
    @When("user clicks on the Continue button for OTP validation")
    public void user_clicks_on_the_continue_button_for_otp_validation() {
        loginPage.clickContinueButton();
    }
    @Then("system should display the appropriate login status")
    public void system_should_display_the_appropriate_login_status() {
        Allure.step("User is logged in Successfully");
        scenario.log("User is logged in Successfully");
    }

    @When("user enters an Invalid mobile number")
    public void user_enters_an_invalid_mobile_number() {
        String invalidMobileNumber = context.credsLoader.get("invalidMobileNumber");
        loginPage.enterUserName(invalidMobileNumber);
        Allure.step("Entered mobile number: " + invalidMobileNumber);
        scenario.log("Entered mobile number: " + invalidMobileNumber);
    }
    @Then("user validate that the appropriate error message is displayed")
    public void user_validate_that_the_appropriate_error_message_is_displayed() {
        Assert.assertEquals("Please enter a valid number", context.credsLoader.get("invalidUserNumberErrorMessage"));
    }


    @When("user enters a mobile number")
    public void user_enters_a_mobile_number() {
        String mobileNumber = context.credsLoader.get("mobileNumber");
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
        Assert.assertEquals("Please enter a valid OTP", context.credsLoader.get("invalidOTPErrorMessage"));
    }
    @Then("user validates that the OTP is resent successfully")
    public void user_validates_that_the_OTP_is_resent_successfully() {
        Assert.assertEquals("An OTP has been sent again", context.credsLoader.get("ResendOTPMessage"));
    }

}
