package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginButton= By.id("menu-button");
    private final By userNameField= By.xpath("//input[@placeholder='Enter Your Mobile Number']");
    private final By passwordField= By.xpath("//input[@type='tel']");
    private final By continueButton= By.xpath("//button[contains(text(), 'Continue')]");
    private final By resendButton= By.xpath("//*[contains(text(),'Resend SMS')]");

    public LoginPage(WebDriver driver) {
        super(driver);
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

    public void clickContinueButton() {
        click(continueButton);
    }

    public void clickResendButton() {
        click(resendButton);
    }
}


