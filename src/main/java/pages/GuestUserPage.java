package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class GuestUserPage extends BasePage{

    public final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------

    private final By category = By.xpath("//a[contains(text(),'Categories')]");
    private final By termsOfUse = By.xpath("//p[contains(text(), 'Terms of Use')]");
    private final By termsAndConditions = By.xpath("//h3[contains(text(), 'TERMS & CONDITIONS')]");
    private final By search = By.xpath("//input[@placeholder='Search']");
    private final By makeUpLabel = By.xpath("//p[contains(text(), 'makeup')]");
    private final By dotAndKeyLabel = By.xpath("//p[contains(text(), 'Dot & Key')]");
    private final By stripBanner = By.xpath("//span[contains(text(),'First Citizen Club Member')]");
    private final By stripBannerLoginUser = By.xpath("//span[contains(text(),\"You're a First Connect Member\")]");
    private final By addToBagPDP = By.xpath("//p[contains(text(),'Add To Bag')]");
    private final By highToLow = By.xpath("//p[contains(text(), 'Price: High to Low')]");
    private final By lowToHigh = By.xpath("//p[contains(text(), 'Price: Low to High')]");
    private final By highValue = By.xpath("(//span[@class='css-1b9e2uo'])[1]");
    private final By lowValue = By.xpath("(//span[@class='css-1b9e2uo'])[6]");
    private final By brand = By.xpath("//div[contains(text(),'Brand')]");
    private final By categories = By.xpath("//div[contains(text(),'Categories')]");
    private final By arceliaBrand = By.xpath("//h6[contains(text(),'Arcelia')]");
    private final By sugarBrand = By.xpath("//h6[contains(text(),'SUGAR')]");
    private final By faceBrand = By.xpath("(//h6[contains(text(),'Face')])[1]");
    private final By arceliaLabel = By.xpath("//span[contains(text(),'Arcelia')]");
    private final By faceLabel = By.xpath("//span[contains(text(),'Face')]");
    private final By sugarLabel = By.xpath("//span[contains(text(),'SUGAR')]");
    private final By firstProductWishlist = By.xpath("(//*[name()='svg'][@class='css-ksipev'])[1]");
    private final By addProductWishlist = By.xpath("//div[@class='MuiBox-root css-0']/div[@class='css-6wmeao']");
    private final By LoginClose = By.xpath("//button[@aria-label='close']");
    private final By productPrize = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-p4mlvh']");
    private final By productOffer = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1pbfhq8'])[1]");
    private final By productDescription = By.xpath("//p[contains(text(),'Product Description')]");
    private final By similarProducts = By.xpath("//p[contains(text(),'SIMILAR PRODUCTS')]");
    private final By reviewRatings = By.xpath("//p[contains(text(),'Review & Ratings')]");
    private final By lakMeSkinNaturalMousseTitle = By.xpath("//p[contains(text(),'Absolute Mattreal Skin Natural Mousse')]");
    private final By narSLongWearFoundationTitle = By.xpath("//p[contains(text(),'Natural Radiant Longwear Foundation - Namibia, 30 ml')]");
    private final By productValueBox = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1j74sq2']");
    private final By productCount = By.xpath("//div[contains(@class,'MuiGrid-item') and contains(@class,'MuiGrid-grid-xs-10')]");



    public GuestUserPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------

    public void clickOnTermsOfUse() {

        scrollAndClickUsingJS(termsOfUse);
    }

    public void validateTermsOfUsePage() {

        isWebElementDisplayed(termsAndConditions);


    }

    public void enterKeyword(String str) {

        enterKeywordOnElement(search, str);
        waitFor(5);
    }

    public void validateMakeupPLP() {

        validateElementText(makeUpLabel, "Makeup");
    }

    public void validateDotAndKeyPLP() {

        validateElementText(dotAndKeyLabel, "Dot & Key");
    }

    public void clickOnStripBanner() {
        isElementPresent(stripBanner);
        safeClick(stripBanner);
    }

    public void clickOnStripBannerLoginUser() {
        isElementPresent(stripBannerLoginUser);
        safeClick(stripBannerLoginUser);
    }

    public void switchToProductWindow() {
        switchToNewWindow();
        waitFor(2);
    }

    public void clickOnAddTCartPDP() {
        isElementPresent(addToBagPDP);
        safeClick(addToBagPDP);
        waitFor(2);
    }

    public void clickOnHighToLowSortBy() {
        isElementPresent(highToLow);
        safeClick(highToLow);
        waitFor(2);
    }

    public void clickOnLowToHighSortBy() {
        isElementPresent(lowToHigh);
        safeClick(lowToHigh);
        waitFor(2);
    }

    public void clickOnArceliaBrand() {
        isElementPresent(arceliaBrand);
        safeClick(arceliaBrand);
    }

    public void clickOnSugarBrand() {
        isElementPresent(sugarBrand);
        safeClick(sugarBrand);
        waitFor(2);
    }

    public void clickOnFaceBrand() {
        isElementPresent(faceBrand);
        safeClick(faceBrand);
    }

    public void clickOnBrandFilter() {
        isElementPresent(brand);
        safeClick(brand);
    }

    public void clickOnCategoriesFilter() {
        waitFor(2);
        isElementPresent(categories);
        safeClick(categories);
    }

    public void clickOnFirstProductWishlist() {
        isElementPresent(firstProductWishlist);
        safeClick(firstProductWishlist);
    }

    public void clickOnWishlistInPDP() {
        isElementPresent(addProductWishlist);
        safeClick(addProductWishlist);
    }

    public void clickOnCloseLogin() {
        isElementPresent(LoginClose);
        safeClick(LoginClose);
    }

    public void validateArceliaLabel() {
        isElementPresent(arceliaLabel);
    }

    public void validateFaceLabel() {
        isElementPresent(faceLabel);
    }

    public void validateSugarLabel() {
        isElementPresent(sugarLabel);
    }

    public void validateHighToLowSortBy() {
        double firstValue = getNumericValue(highValue);
        System.out.println("FirstValue: " + firstValue);
        double secondValue = getNumericValue(lowValue);
        System.out.println("SecondValue: " + secondValue);

        Assert.assertTrue(firstValue > secondValue, "Sorting failed: First value is not greater than second value"
        );
    }

    public void validateLowToHighSortBy() {
        double firstValue = getNumericValue(highValue);
        System.out.println("FirstValue: " + firstValue);
        double secondValue = getNumericValue(lowValue);
        System.out.println("SecondValue: " + secondValue);

        Assert.assertTrue(firstValue < secondValue, "Sorting failed: First value is not less than second value"
        );
    }

    public boolean validatePDPComponentsByText(List<String> expectedSections) {
        isElementPresent(productPrize);
        List<By> expectedComponents = Arrays.asList(
                productPrize,
                productOffer,
                productDescription,
                similarProducts,
                reviewRatings

        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean allFound = true;
        for (By locator : expectedComponents) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (TimeoutException e) {
                allFound = false;
            }
        }
        return allFound;
    }

    public void validateAllProductQuantityIsOne(By locator) {

        List<WebElement> quantities = driver.findElements(locator);

        for (WebElement quantity : quantities) {
            String value = quantity.getText().trim();
            Assert.assertEquals(value, "1", "Quantity is not 1");
        }
    }

    public void validateProductCountInCart(By locator, int expectedCount) {

        List<WebElement> products = driver.findElements(locator);

        Assert.assertEquals(
                products.size(),
                expectedCount,
                "Product count mismatch in cart"
        );
    }

    public void validateProductCount(int expectedCount) {

        validateElements(productCount);
        validateProductCountInCart(productCount, expectedCount);
    }

    public void validateLakMeSkinNaturalMousseTitle() {

        isElementPresent(lakMeSkinNaturalMousseTitle);

    }

    public void validateNarSLongWearFoundationTitle() {

        isElementPresent(narSLongWearFoundationTitle);
    }


}
