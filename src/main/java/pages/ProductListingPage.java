package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductListingPage extends BasePage {

    // ---------- Locators ----------
    public final By productList = By.xpath("//div[@data-item-type='ProdctSCCard']");
    private final By shade = By.xpath("//button[contains(text(),'Select Shade')]");
    private final By shadePopup = By.xpath("(//div[@class='MuiBox-root css-rs1ufz'])[2]");
    private final By productShadePopup = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-4bv7er']");
    private final By addToBag = By.xpath("//button[contains(text(),'Add To Bag')]");
    private final By firstProductCard = By.xpath("(//div[contains(@class, 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-6 MuiGrid-grid-md-4 css-1ho082a')])[1]");
    private final By secondProductCard = By.xpath("(//div[contains(@class, 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-6 MuiGrid-grid-md-4 css-1ho082a')])[2]");
    private final By productName = By.xpath("//p[contains(text(),'Chambor')]");
    private final By productPrice = By.xpath("//span[contains(@class,'css-1b9e2uo')]");
    private final By productOffer = By.xpath("//p[contains(text(),'Available')]");
    private final By productCountText = By.xpath("//p[contains(normalize-space(.),'Products')]");
    private final By viewDetails = By.xpath("//button[contains(text(),'View Details')]");
    private final By productNamePLP = By.xpath("(//p[@class='css-6r9hbw'])[1]");
    private final By clearAllBtn = By.xpath("//p[contains(text(),'CLEAR ALL')]");
    private final By foundationsLabelPLP = By.xpath("//p[contains(text(),'Foundations')]");
    private final By macMatteLipstickMehrLabelPLP = By.xpath("//p[contains(text(),'M.A.C Matte Lipstick - Mehr')]");
    private final By search = By.xpath("//input[@placeholder='Search']");
    private final By lipstickLabel = By.xpath("//p[contains(text(), 'lipstick')]");
    private final By sortByPLP = By.xpath("//p[contains(text(), 'Sort By')]");
    private final By highToLow = By.xpath("//p[contains(text(), 'Price: High to Low')]");
    private final By lowToHigh = By.xpath("//p[contains(text(), 'Price: Low to High')]");
    private final By filtersPDP = By.xpath("//div[contains(text(), 'Filters')]");
    private final By brandPDP = By.xpath("//div[contains(text(),'Brand')]");
    private final By upArrowBtnPLP = By.xpath("//img[@alt='back2top']");

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------

    public void moveToProduct() {

        isElementPresent(productList);
        moveToElement(productList);
    }

    public void validateFoundationsLabelPLP() {

        validateElementText(foundationsLabelPLP, "Foundations");
    }

    public void validateMacMatteLipstickMehrLabelPLP() {

        validateElementText(macMatteLipstickMehrLabelPLP, "M.A.C Matte Lipstick - Mehr");
        waitFor(3);
    }

    public void validateShade() {

        try {
            moveToProduct();

            if (isElementPresent(shade)) {
                safeClick(shade);
            }
        } catch (Exception e) {}
    }

    public void selectShadeVariant() {
        try {
            if (isElementPresent(shadePopup)) {
                safeClick(shadePopup);
            }
            if (isElementPresent(addToBag)) {
                safeClick(addToBag);
            }
            waitFor(2);
        } catch (Exception e) {
        }
    }

    public String getProductShadePopupText() {
        WebElement popupText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productShadePopup));
        return popupText.getText().trim();
    }

    public String cartProductName() {
        WebElement popupText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productShadePopup));
        return popupText.getText().trim();
    }

    public Map<String, String> validateFirstProductDetails() {

        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductCard));

        String name = firstProduct.findElement(productName).getText().trim();
        String price = firstProduct.findElement(productPrice).getText().replaceAll("\\s+", "").trim();
        String offerText = firstProduct.findElement(productOffer).getText().trim();

        Assert.assertFalse(name.isEmpty(), "Product name is empty");
        Assert.assertTrue(price.startsWith("₹"), "Price is incorrect");

        Assert.assertTrue(
                offerText.equalsIgnoreCase("Free Product Available")
                        || offerText.matches("\\d+ Offers Available"),
                "Offer text validation failed"
        );

        Map<String, String> productDetails = new HashMap<>();
        productDetails.put("name", name);
        productDetails.put("price", price);
        productDetails.put("offer", offerText);

        return productDetails;
    }

    public int getProductCount() {

        WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productCountText));

        String rawText = countElement.getText().trim();
        System.out.println("Raw text: " + rawText);

        int productCount = Integer.parseInt(rawText.replaceAll("[^0-9]", ""));

        System.out.println("Product Count: " + productCount);

        return productCount;
    }

    public void validateViewDetailsAndAddToBag() {

        try {
            moveToProduct();

            Assert.assertTrue(isElementPresent(viewDetails),
                    "View Details option is NOT visible on hover");

            Assert.assertTrue(isElementPresent(addToBag),
                    "Add To Bag option is NOT visible on hover");

        } catch (Exception e) {
            Assert.fail("Hover validation failed - " + e.getMessage());
        }
    }

    public String getProductNamePLP() {

        WebElement productNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productNamePLP));

        String productName = productNameElement.getText().trim();
        System.out.println("Product Name from PLP: " + productName);

        return productName;
    }

    public void clickOnClearAllBtn() {

        safeClick(clearAllBtn);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(clearAllBtn));
    }

    public void enterKeyword(String str) {

        enterKeywordOnElement(search, str);
        waitFor(5);
    }

    public void validateMakeupPLP() {

        validateElementText(lipstickLabel, "Lipstick");
    }

    public boolean validatePLPComponentsByText(List<String> expectedSections) {
        isElementPresent(foundationsLabelPLP);
        List<By> expectedComponents = Arrays.asList(
                foundationsLabelPLP,
                sortByPLP,
                lowToHigh,
                highToLow,
                filtersPDP,
                brandPDP

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

    public void scrollToBottomPageAndClickUpArrow() {
        scrollEndOfPage();
        isElementPresent(upArrowBtnPLP);
        safeClick(upArrowBtnPLP);
        waitFor(2);
    }

    public boolean isUpArrowBtnVisible() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(upArrowBtnPLP));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Map<String, String> validateFirstProductOfferTile() {

        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductCard));

        String offerText = firstProduct.findElement(productOffer).getText().trim();

        Assert.assertTrue(
                offerText.equalsIgnoreCase("Free Product Available")
                        || offerText.matches("\\d+ Offers Available"),
                "Offer text validation failed"
        );

        Map<String, String> productDetails = new HashMap<>();
        productDetails.put("offer", offerText);

        return productDetails;
    }

    public Map<String, String> validateSecondProductOfferTile() {

        WebElement SecondProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductCard));

        String offerText = SecondProduct.findElement(productOffer).getText().trim();

        Assert.assertTrue(
                offerText.equalsIgnoreCase("Free Product Available")
                        || offerText.matches("\\d+ Offers Available"),
                "Offer text validation failed"
        );

        Map<String, String> productDetails = new HashMap<>();
        productDetails.put("offer", offerText);

        return productDetails;
    }

}


