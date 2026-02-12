package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{

    private final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------
    private final By homeButton = By.xpath("//img[@alt='Image 1']");
    private final By category = By.xpath("//a[contains(text(),'Categories')]");
    private final By search = By.xpath("//input[@placeholder='Search']");
    private final By makeUp = By.xpath("//span[contains(text(),'Makeup')]");
    private final By foundation = By.xpath("//p[contains(text(),'Foundations')]");
    public final By productList = By.xpath("//div[@data-item-type='ProdctSCCard']");
    public final By anotherProductList = By.xpath("(//div[@data-item-type='ProdctSCCard'])[3]");
    private final By shade = By.xpath("//button[contains(text(),'Select Shade')]");
    private final By shadePopup = By.xpath("(//div[@class='MuiBox-root css-rs1ufz'])[2]");
    private final By addToBag = By.xpath("//button[contains(text(),'Add To Bag')]");
    private final By moveToBag = By.xpath("//button[contains(text(),'Move To Bag')]");
    private final By viewDetails = By.xpath("//button[contains(text(),'View Details')]");
    private final By hair = By.xpath("(//span[contains(text(),'Hair')])[1]");
    private final By conditioners = By.xpath("(//p[contains(text(),'Conditioners')])[2]");
    private final By skin = By.xpath("//span[contains(text(),'Skin')]");
    private final By facial = By.xpath("//p[contains(text(),'Facial Wipes')]");
    private final By addWishlist = By.xpath("(//div[@class='MuiGrid-root css-shd5b'])[5]");
    private final By lowToHigh = By.xpath("(//input[@type='radio'])[2]");
    public final By highToLow = By.xpath("(//input[@type='radio'])[3]");
    private final By categoryFilter = By.xpath("(//div[contains(text(),'Category')])[1]");
    private final By makeUpFilter = By.xpath("(//h6[contains(text(),'Makeup')])[1]");
    private final By brandsFilter = By.xpath("(//div[contains(text(),'Brand')])[1]");
    private final By lifeFilter = By.xpath("(//h6[contains(text(),'Clinique')])[1]");
    private final By pin = By.xpath("//input[@placeholder='Enter PIN code']");
    private final By change = By.xpath("//button[contains(text(),'CHANGE')]");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------
    public void clickOnHomeButton(int max) {
        driver.navigate().refresh();
        isDisplayed(homeButton);
        for (int i = 0; i < max; i++) {
            safeClick(homeButton);
        }
    }

    public void clickOnCategory() {
        isDisplayed(category);
        moveToElement(category);
    }
    public void validateCategory() {
        isDisplayed(category);
    }

    public void validateSearch() {

        validateElements(search);
    }

    public void enterKeywordInSearchBox() {
        isDisplayed(search);
        safeClick(search);
        waitFor(2);

    }
    public void clickOnMakeUp() {
        clickOnCategory();
        isWebElementDisplayed(makeUp);
        moveToElement(makeUp);
    }
    public void clickOnHair() {
        clickOnCategory();
        isWebElementDisplayed(hair);
        moveToElement(hair);
    }
    public void clickOnSkin() {
        clickOnCategory();
        isWebElementDisplayed(skin);
        moveToElement(skin);
    }
    public void clickOnFoundation() {
        isElementPresent(foundation);
        safeClick(foundation);
    }
    public void clickOnConditioner() {
        isElementPresent(conditioners);
        safeClick(conditioners);
    }
    public void clickOnFacial() {
        isElementPresent(facial);
        safeClick(facial);
    }

    public void moveToProduct() {
        isElementPresent(productList);
        moveToElement(productList);
    }

    public void moveToAnotherProduct() {
        isElementPresent(anotherProductList);
        moveToElement(anotherProductList);
    }

    public void validateShadeOrBag() {
        try {
            moveToProduct();

            if (isElementPresent(shade)) {
                safeClick(shade);
                isElementPresent(shadePopup);
                safeClick(shadePopup);
            }
            if (isElementPresent(addToBag)) {
                safeClick(addToBag);
            }
        } catch (Exception e) {}
    }

    public void validateAnotherShadeOrBag() {
        try {
            moveToAnotherProduct();

            if (isDisplayed(shade)) {
                safeClick(shade);
//                isElementPresent(shadePopup);
//                safeClick(shadePopup);
            }
            if (isElementPresent(addToBag)) {
                safeClick(addToBag);
            }
        } catch (Exception e) {}
    }

    public void validateShadeOrMoveToBag() {
        try {
            moveToProduct();

            if (isElementPresent(shade)) {
                safeClick(shade);
                isElementPresent(shadePopup);
                safeClick(shadePopup);
            }
            if (isElementPresent(moveToBag)) {
                safeClick(moveToBag);
            }
        } catch (Exception e) {}
    }

    public void validateShadeOrDetails() {

        try {
            moveToProduct();

            if (isElementPresent(shade)) {
                safeClick(shade);
                isElementPresent(shadePopup);
                safeClick(shadePopup);
            }
            if (isElementPresent(viewDetails)) {
                safeClick(viewDetails);
            }
        } catch (Exception e) {}
    }

    public void clickOnAddWishlist() {
        isElementPresent(addWishlist);
        safeClick(addWishlist);
    }

    public void clickOnPriceLowToHigh() {
        isElementPresent(lowToHigh);
        safeClick(lowToHigh);
    }

    public void clickOnPriceHighToLow() {
        isElementPresent(highToLow);
        safeClick(highToLow);
    }

    public void clickOnFilterCategory() {
        isElementPresent(categoryFilter);
        safeClick(categoryFilter);
        isElementPresent(makeUpFilter);
        safeClick(makeUpFilter);
    }

    public void clickOnBrandsFiler() {
        isElementPresent(brandsFilter);
        safeClick(brandsFilter);
        isElementPresent(lifeFilter);
        safeClick(lifeFilter);
    }

    public void enterPostalCode(String str) {
        scrollDown(pin);
        isElementPresent(pin);
        enterTextOnElement(pin, str);
    }

    public void clickOnChange() {
        isElementPresent(change);
        safeClick(change);
    }

    public boolean clickProductByIndex(By locator,int index) {
        try {
            waitForOverlayToDisappear();
            List<WebElement> productList = driver.findElements(locator);

            if (index >= 0 && index < productList.size()) {
                WebElement product = productList.get(index);
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", product);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(product)).click();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
