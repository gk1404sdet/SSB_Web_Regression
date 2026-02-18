package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class WishlistPage extends BasePage{

    // ---------- Locators (unchanged) ----------
    private final By wishlist = By.xpath("(//div[@class='MuiBox-root css-1dy8gno'])[1]");
    private final By wishlistPage = By.xpath("//*[contains(text(),'Products Wishlisted')]");
    private final By wishlistRemoveIcon = By.xpath("(//div[contains(@class,'MuiGrid-root css-shd5b')]//*[local-name()='svg'])[3]");
    private final By removeItem = By.xpath("(//*[text()='Remove Item'])[2]");


    private final By productWishlisted = By.xpath("//p[contains(text(), 'Products Wishlist')]");
    private final By search = By.xpath("//input[@placeholder='Search']");
    private final By homeButton = By.xpath("//img[@alt='Image 1']");
    private final By emptyCartBtn = By.xpath("(//div[@class='MuiBox-root css-1dy8gno'])[2]");
    private final By removeWishlist = By.xpath("//*[name()='svg' and contains(@class,'css-1exo64a')]");
    private final By addToWishlistPDP = By.xpath("//div[@class='css-6wmeao']//*[name()='svg']");
    private final By shareIconPDP = By.xpath("(//div[@class='MuiStack-root css-ehoejh']//*[name()='svg'])[1]");
    private final By removeAllWishlist = By.xpath("//div[contains(@class,'css-shd5b')]//*[name()='svg']");
    private final By removeItemBtn = By.xpath("(//p[contains(text(),'Remove Item')])[2]");


    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    // ---------------------- Public methods (kept signatures + behavior) ----------------------
    public void clickWishlist(){
        waitForOverlayToDisappear();
        click(wishlist);
    }

    public String getWishlistPageText(){
        driver.navigate().refresh();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistPage)).getText();
    }

    public void clickWishlistRemoveIcon(){
        waitForOverlayToDisappear();
        click(wishlistRemoveIcon);
    }

    public void clickRemoveItem(){
        waitForVisibleElement(removeItem);
        click(removeItem);
    }


    public boolean validateWishlistComponentsByText(List<String> expectedSections) {
        isElementPresent(productWishlisted);
        List<By> expectedComponents = Arrays.asList(
                productWishlisted,
                search,
                homeButton,
                emptyCartBtn
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

    public int getWishlistedProductCount(By locator) {

        String text = driver.findElement(locator).getText();

        return Integer.parseInt(text.split(" ")[0]);
    }

    public int validateWishlistedCount(int expectedCount) {

        int actualCount = getWishlistedProductCount(productWishlisted);
        Assert.assertEquals(actualCount, expectedCount, "Wishlist count mismatch");
        return actualCount;
    }

    public void validateProductToRemoveWishlist() {

        validateElements(removeWishlist);
    }

    public void deleteAllWishlistedProducts() {

        isElementPresent(removeWishlist);
    }

    public int addProductsToWishlist(int count) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 1; i <= count; i++) {
            By wishlistIcon = By.xpath(String.format("(//div[@class='MuiGrid-root css-shd5b'])[%d]", i));
            isElementPresent(wishlistIcon);
            System.out.println("WishlistIcon is present");
//            WebElement element = driver.findElement(wishlistIcon);
            scrollAndClickUsingJS(wishlistIcon);
//            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
//            js.executeScript("arguments[0].click();", element);
            System.out.println("WishlistIcon is clicked");
            validateErrorMessageByPartialText("Product successfully added to your wishlist", "Product successfully added to your wishlist");
            waitFor(3);
        }

        return count;
    }

    public void clickOnAddToWishlistPDP() {
        isElementPresent(addToWishlistPDP);
        safeClick(addToWishlistPDP);
        waitFor(2);
    }

    public void clickOnShareIconPDP() {
        isElementPresent(shareIconPDP);
        safeClick(shareIconPDP);
    }

    public void removeAllProductsFromWishlist() {
        List<WebElement> removeButtons = driver.findElements(removeAllWishlist);
        int count = removeButtons.size();

        if (count == 0) {
            System.out.println("No products present in wishlist");
            return;
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Total products in wishlist: " + count);

        while (true) {

            List<WebElement> buttons = driver.findElements(removeAllWishlist);

            if (buttons.isEmpty()) {
                System.out.println("All products removed from wishlist");
                break;
            }

            WebElement firstRemoveButton = buttons.get(0);

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstRemoveButton);
            firstRemoveButton.click();
            isWebElementDisplayed(removeItemBtn);
            safeClick(removeItemBtn);
            validateErrorMessageByPartialText("Product has been removed from wishlist", "Product has been removed from wishlist");
            waitFor(2);
        }
    }

}
