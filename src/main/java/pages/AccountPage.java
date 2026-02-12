package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AccountPage extends BasePage {

    // ---------- Locators (unchanged) ----------
    private final By profile = By.xpath("//*[text()='Profile']");
    private final By myOrders = By.xpath("//li[contains(text(),'My Orders')]");
    private final By manageAddress = By.xpath("//li[contains(text(),'Manage Address')]");
    private final By fcc = By.xpath("//li[contains(text(),'First Citizen Club')]");
    private final By myWallet = By.xpath("//li[contains(text(),'My Wallet')]");
    private final By helpAndSupport = By.xpath("//li[contains(text(),'Help & Support')]");
    private final By privacyPolicy = By.xpath("//li[contains(text(),'Privacy Policy')]");
    private final By firstName1 = By.xpath("//*[text()='First Name']");
    private final By firstCardBenefit = By.xpath("//*[text()='Updates On Latest Sales & Discounts ']");
    private final By firstConnectCard = By.xpath("//*[text()='FIRST CONNECT']");
    private final By silverCard = By.xpath("//*[text()='SILVER EDGE']");
    private final By silverCardBenefit = By.xpath("//*[text()='2 Reward Points For Every ₹200 Purchase']");
    private final By platinumCard = By.xpath("//*[text()='PLATINUM AURA']");
    private final By platinumCardBenefit = By.xpath("//*[text()='6 Reward Points For Every ₹200 Purchase']");
    private final By blackCard = By.xpath("//*[text()='BLACK ']");
    private final By blackCardBenefit = By.xpath("//*[text()='20 Reward Points For Every ₹200 Purchase']");
    private final By goldenGlowCard = By.xpath("//*[text()='GOLDEN GLOW']");
    private final By goldenCardBenefit = By.xpath("//*[text()='4 Reward Points For Every ₹200 Purchase']");
    private final By joinNow = By.xpath("//*[text()='Join Now']");
    private final By upgradeSilverButton = By.xpath("(//*[text()='Upgrade to Black'])[2]");
    private final By upgradeBlackButton = By.xpath("//p[text()='Bag']");
    private final By closeButton = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']");
    private final By scrollUpButton = By.xpath("//img[@alt='back2top']");
    private final By membershipLabel = By.xpath("//*[text()='Membership']");
    private final By manageAddress1 = By.xpath("//*[text()='Manage Address']");
    private final By newAddAddress = By.xpath("//p[contains(text(),'Add Address')]");
    private final By fName = By.xpath("//input[@placeholder='Enter First Name']");
    private final By lName = By.xpath("//input[@placeholder='Enter Last Name']");
    private final By mobNo = By.xpath("//input[@placeholder='Enter Phone Number']");
    private final By pinCode = By.xpath("//input[@placeholder='Enter Pin Code']");
    private final By address = By.xpath("//textarea[@placeholder='Enter Address']");
    private final By addressType = By.xpath("//span[contains(text(),'Work')]");
    private final By addAdd = By.xpath("//button[contains(text(),'add address')]");
    private final By editOption = By.xpath("(//button[contains(text(),'Edit')])[2]");
    private final By updateAddress = By.xpath("//button[contains(text(),'update address')]");
    private final By deleteAddress = By.xpath("(//button[contains(text(),'Remove')])[2]");
    private final By confirmDelete = By.xpath("(//p[contains(text(),'Remove Address')])[3]");
    private final By onlineName = By.xpath("//*[text()='Online']");
    private final By firstOrder = By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/p");
    private final By orderID = By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div/p[2]");
    private final By searchInOrders = By.xpath("//*[@id=':r3:']");
    private final By profilePicture = By.xpath("//*[name()='path' and contains(@d,'M12 12c2.2')]");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By gender = By.xpath("//input[@type='radio']");
    private final By updateChangesBtn = By.xpath("//button[contains(text(),'Update Changes')]");
    private final By firstConnect = By.xpath("(//p[contains(text(),'FIRST CONNECT')])[2]");
    private final By silver = By.xpath("(//p[contains(text(),'SILVER EDGE')])[2]");
    private final By golden = By.xpath("//p[contains(text(),'GOLDEN GLOW')]");
    private final By platinum = By.xpath("//p[contains(text(),'PLATINUM AURA')]");
    private final By black = By.xpath("//p[contains(text(),'BLACK')]");
    public final By contactUs = By.xpath("//*[text()='Contact Us']");
    


    
    
    
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    // ---------------------- Public methods (kept signatures + behavior) ----------------------
   public List<String> validateAccountComponentsByText() {
       List<By> cartOptions = Arrays.asList(
               profile,
               myOrders,
               manageAddress,
               fcc,
               myWallet,
               helpAndSupport,
               privacyPolicy

       );
       List<String> missingComponents = new ArrayList<>();
       for (By locator : cartOptions) {
           try {
               if (!isElementPresent(locator)) {
                   missingComponents.add(getText(locator));
               }
           } catch (Exception e) {
               missingComponents.add(getText(locator));
           }
       }
       return missingComponents;
   }

    public void clickOnProfile() {
        safeClick(profile);
    }

    public String getFirstNameLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstName1)).getText();
    }

    public void clicksOnFCC() {
        isElementPresent(fcc);
        safeClick(fcc);
    }

    public String getMembershipLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(membershipLabel)).getText();
    }

    public void first_ConnectCard() {
        isElementPresent(firstConnectCard);
        hoverOnElement(firstConnectCard);
    }

    public String getFirstCardBenefitText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstCardBenefit)).getText();
    }

    public void clickSilverCard() {
        isElementPresent(silverCard);
        hoverOnElement(silverCard);
    }

    public String getSilverCardBenefitText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(silverCardBenefit)).getText();
    }

    public void clickPlatinumCard() {
        isElementPresent(platinumCard);
        hoverOnElement(platinumCard);
    }

    public String getPlatinumCardBenefitText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(platinumCardBenefit)).getText();
    }

    public void clickBlackCard() {
        isElementPresent(blackCard);
        hoverOnElement(blackCard);
    }

    public String getBlackCardBenefitText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blackCardBenefit)).getText();
    }

    public void golden_GlowCard() {
        isElementPresent(goldenGlowCard);
        hoverOnElement(goldenGlowCard);
    }

    public String getGoldenCardBenefitText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(goldenCardBenefit)).getText();
    }

    public void clickJoinNow() {
        isElementPresent(joinNow);
        safeClick(joinNow);
    }

    public String verifyOnSilver() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(upgradeSilverButton)).getText();
    }

    public void clickCloseButton() {
        isElementPresent(closeButton);
        safeClick(closeButton);
    }

    public String verifyOnPlatinum() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(upgradeSilverButton)).getText();
    }

    public String verifyOnBlack() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(upgradeBlackButton)).getText();
    }

    public void scrollDownPage() {
        if(!isDisplayed(contactUs)) {
            scrollDown(contactUs);
        }
        isDisplayed(contactUs);
    }

    public String verifyingDown() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs)).getText();
    }

    public void scrollTopPage() {
        waitForPresenceOfElement(scrollUpButton);
        safeClick(scrollUpButton);
    }

    public String verifyingTop() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(membershipLabel)).getText();
    }

    public void uploadProfilePicture() {
        WebElement upload = driver.findElement(By.id("upload-button"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", upload);

        String path = System.getProperty("user.dir") + File.separator+ ("src/test/resources/Profile/ssb_logo_new.png").replace("/",File.separator);
        upload.sendKeys(path);

        String a = driver.findElement(By.id("upload-button")).getAttribute("src");
        System.out.println(a);
    }

    public String validateProfilePicture() {
        return driver.findElement(By.id("upload-button")).getAttribute("src");
    }

    public String getEnteredName() {
        try {
            if (isWebElementDisplayed(firstName)) {
                return find(firstName).getAttribute("value");
            } else {
                return find(lastName).getAttribute("value");
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void enterFirstName(String name) {
        isWebElementDisplayed(firstName);
        safeClick(firstName);
        enterTextOnElement(firstName, name);
    }

    public void enterLastName(String name) {
        isWebElementDisplayed(lastName);
        safeClick(lastName);
        enterTextOnElement(lastName, name);
    }

    public void toggleGenderSelection() {
        List<WebElement> genders = findAll(gender);
        if (genders.size() >= 2) {
            WebElement maleGender = genders.get(0);
            WebElement femaleGender = genders.get(1);
            String aria = maleGender.getAttribute("aria-checked");
            boolean isMaleSelected = "true".equalsIgnoreCase(aria);
            safeClick(isMaleSelected ? femaleGender : maleGender);
        } else {
            throw new RuntimeException("Gender elements not found or insufficient count");
        }
    }

    public void clickOnTheUpdateChanges() {
        if (isElementPresent(updateChangesBtn)) {
            WebElement update = retryGetElement(updateChangesBtn);
            if (update.isDisplayed() && update.isEnabled()) {
                safeClick(update);
            }
        }
    }


    public void clickOnManageAddress() {
        safeClick(manageAddress1);
    }

    public void clicksOnNewAddress() {
        safeClick(newAddAddress);
    }

    public void enterUpdateFirstName(String name) {
        isWebElementDisplayed(fName);
        safeClick(fName);
        enterTextOnElement(fName, name);
    }

    public void enterUpdateLastName(String name) {
        isWebElementDisplayed(lName);
        safeClick(lName);
        enterTextOnElement(lName, name);
    }

    public void enterTheMobile(String no) {
        enterTextOnElement(mobNo, no);
    }

    public void enterThePinCode(String pin) {
        enterTextOnElement(pinCode, pin);
    }

    public void enterTheAddress(String adr) {
        scrollDown(address);
        enterTextOnElement(address, adr);
    }

    public void clickOnAddressType() {
        safeClick(addressType);
    }

    public void clickOnAddAddress() {
        isElementPresent(addAdd);
        safeClick(addAdd);
    }

    public void clickOnEdit() {
        isElementPresent(editOption);
        safeClick(editOption);
    }

    public void clickOnUpdateAddress() {
        isElementPresent(updateAddress);
        safeClick(updateAddress);
    }

    public void clickOnRemove() {
        isElementPresent(deleteAddress);
        safeClick(deleteAddress);
    }

    public void clickOnConfirmRemoveButton() {
        isElementPresent(confirmDelete);
        safeClick(confirmDelete);
    }

    public void clickOnMyOrders() {
        safeClick(myOrders);
    }

    public String getOnlineLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(onlineName)).getText();
    }

    public void captureMyOrderID() {
        isElementPresent(firstOrder);
        clickOnElement(firstOrder);
    }

    public String orderID() {
        return getText(orderID);
    }

    public void enterMyOrderID(String str) {
        isElementPresent(searchInOrders);
        clickOnElement(searchInOrders);
        enterTextOnElement(searchInOrders,str);
    }

    public void clickProfilePicture() {
        isElementPresent(profilePicture);
    }

    public List<String> validateFCCComponentsByText() {
        List<By> fccComponent = Arrays.asList(
                firstConnect,
                silver,
                golden,
                platinum,
                black
        );
        List<String> missingComponents = new ArrayList<>();
        for (By option : fccComponent) {
            try {
                if (!isElementPresent(option)) {
                    missingComponents.add(getText(option));
                }
            } catch (Exception e) {
                missingComponents.add(getText(option));
            }
        }
        return missingComponents;
    }
}