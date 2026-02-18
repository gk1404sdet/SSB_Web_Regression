package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.Color;

import java.time.Duration;
import java.util.*;

public class HeaderPage extends BasePage {

    public final JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- Locators ----------
    private final By wishlist = By.xpath("(//div[@class='MuiBox-root css-1dy8gno'])[1]");
    public final  By productCard = By.xpath("//div[@data-item-type='ProdctSCCard']");
    public final By proDetails = By.xpath("//p[contains(text(),'Product Description')]");
    private final By removeWishlist = By.xpath("//div[@class='MuiGrid-root css-shd5b']");
    private final By remove = By.xpath("(//p[contains(text(),'Remove Item')])[2]");
    private final By searchEditBox = By.xpath("//input[@placeholder='Search']");
    public final By redLip = By.xpath("//p[contains(text(),'red Lipstick')]");
    public final By trendingSearch = By.xpath("//p[contains(text(),'Zayn & Myza')]");
    public final By cartBadgeNumber = By.xpath("//span[contains(@class,'MuiBadge-badge')]");


    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------
    public void clickOnWishlist() {
        isElementPresent(wishlist);
        safeClick(wishlist);
    }
    public int getProductCardCount() {

        List<WebElement> cards = driver.findElements(productCard);

        int count = cards.size();
        System.out.println("Total product cards count: " + count);

        return count;
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
    public void clickOnRemoveWishlist(int index) {
        isElementPresent(removeWishlist);
        safeClick(removeWishlist);
    }
    public void clickOnRemoveItem() {
        isElementPresent(remove);
        safeClick(remove);
    }

    public void clicksOnTheSearEditBox() {
        wait.until(ExpectedConditions.elementToBeClickable(searchEditBox)).click();
    }

    public void enterKeyword(String str) {
        enterTextOnElement(searchEditBox, str);
    }

    public void clickOnTrendingProduct() {
        isElementPresent(trendingSearch);
        safeClick(trendingSearch);
    }

    public String getBackgroundColorHex(By locator) {
        String rgba = driver.findElement(locator)
                .getCssValue("background-color");
        return Color.fromString(rgba).asHex();
    }

//    String afterColor = getBackgroundColorHex(payButton);
//    Assert.assertNotEquals(beforeColor,afterColor,"Background color did not change");

    public int getCartCount() {
        List<WebElement> badges = driver.findElements(cartBadgeNumber);
        if (badges.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(badges.get(0).getText().trim());
    }

    public int waitAndGetUpdatedCartCount(int beforeCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> getCartCount() > beforeCount);
        return getCartCount();
    }



}

