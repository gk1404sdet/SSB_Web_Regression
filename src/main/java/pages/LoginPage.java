package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;


public class LoginPage extends BasePage {

    private final By loginButton= By.id("menu-button");
    private final By userNameField= By.xpath("//input[@placeholder='Enter Your Mobile Number']");
    private final By passwordField= By.xpath("//input[@type='tel']");
    private final By continueButton= By.xpath("//button[contains(text(), 'Continue')]");
    private final By resendButton= By.xpath("//*[text()='Resend SMS']");
    private final By maxOtpAttempts= By.xpath("//p[contains(text(),'Since you have exceeded the maximum OTP attempts')]");
    private final By logoutButton= By.xpath("//li[contains(text(), 'Logout')]");
    private final By invalidNumber= By.xpath("//*[contains(text(),'Please enter a valid number')]");
    private final By invalidOTPError= By.xpath("//*[contains(text(),'Please enter a valid OTP')]");
    private final By resendOTPMessage= By.xpath("//*[contains(text(),'An OTP has been sent again')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOnProfileBtn() {
        isDisplayed(loginButton);
        hoverOnElement(loginButton);
    }

    public void clickLoginButton() {
       click(loginButton);
    }

    public void enterUserName(String userName) {
        waitForVisibleElement(userNameField);
        click(userNameField);
        sendKeys(userNameField, userName);
    }

    public void enterPassword(String password) {
        waitForVisibleElement(passwordField);
        click(passwordField);
        sendKeys(passwordField, password);
    }


    public void clickOnContinue() {
        click(continueButton);
    }

    public boolean isMaxOtpLimitDisplayed() {
        return isElementPresentFast(maxOtpAttempts, 2);
    }

    public void clickResendButton() {
        waitForVisibleElement(resendButton);
        click(resendButton);
    }

    public void clickLogoutButton() {
        isDisplayed(logoutButton);
        click(logoutButton);
    }

    public String getInvalidNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidNumber)).getText();
    }

    public String getInvalidOTPErrorText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidOTPError)).getText();
    }

    public String getResendOTPMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resendOTPMessage)).getText();
    }
}


