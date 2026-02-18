package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
    }

    public void goTo(String url) {
        driver.get(url);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(value);
    }

    protected void clear(By locator) {
        driver.findElement(locator).clear();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    protected void waitForVisibleElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementPresentFast(By locator, int timeoutInSeconds) {
        long endTime = System.currentTimeMillis() + (timeoutInSeconds * 1000L);

        while (System.currentTimeMillis() < endTime) {
            if (!driver.findElements(locator).isEmpty()) {
                return true;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {}
        }
        return false;
    }



    protected void jsClick(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void clickOnElement(By element, int... param) {
        waitForPresenceOfElement(element);
        if (param.length == 1) {
            WebElement elementForClick = driver.findElements(element).get(param[0]);
            wait.until(ExpectedConditions.visibilityOf(elementForClick));
            elementForClick.click();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            driver.findElement(element).click();
        }
    }

    public void enterTextOnElement(By element, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(element).sendKeys(Keys.BACK_SPACE);
        driver.findElement(element).sendKeys(value);
    }

    public void enterKeywordOnElement(By element, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
//        driver.findElement(element).click();
//        driver.findElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        driver.findElement(element).sendKeys(Keys.BACK_SPACE);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
        driver.findElement(element).sendKeys(Keys.ENTER);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void clickJsUsingBy(By loc) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", driver.findElement(loc));
        driver.findElement(loc).click();
    }

    public void clickOnTextButton(String button) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + button + "')]")));
        clickOnElement(By.xpath("//*[contains(text(),'" + button + "')]"));
    }

    public void scrollUp(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
    }

    public boolean isWebElementDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public void waitForPresenceOfElement(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public boolean isElementPresent(By locatorKey) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        try {
            driver.findElement(locatorKey);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            return false;
        }
    }

    // ---------------------- Utility helpers (small, fast, reused) ----------------------

    /**
     * Clicks using BasePage's click when possible (centralized waits),
     * falls back to JS click on failure (handles overlays/stale issues).
     */

    public void screenShot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File screenshotAs = ts.getScreenshotAs(OutputType.FILE);

        File f = new File("target/Screenshots/" + screenshotAs.toString() + ".png");

        FileUtils.copyFile(screenshotAs, f);
    }

    public void scrollDown(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", driver.findElement(locator));
    }


    public void moveToElement(By locator) {
        isElementPresent(locator);
        actions.moveToElement(driver.findElement(locator)).pause(Duration.ofSeconds(2)).build().perform();
    }

    public void switchToNewWindow() {

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }


    public void closeChildWindowAndSwitchBack() {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        if (allWindows.size() > 1) {
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    driver.close();
                }
            }
            // Switch back to parent
            driver.switchTo().window(parentWindow);
        } else {
        }
    }

    public void scrollToElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            highlightElement(locator);

        } catch (Exception e) {
            org.testng.Assert.fail("Error while scrolling to element: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void scrollTillElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        highlightElements(element);
    }

    public void scrollEndOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red';", element);
    }

    public void highlightElements(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red';", element);
        } catch (JavascriptException | StaleElementReferenceException e) {
            System.out.println("Could not highlight element: " + e.getMessage());
        }
    }

    public void waitForOverlayToDisappear() {
        try {
            By overlayLocator = By.cssSelector("div[class*='inset-0'][class*='bg-neutral']");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
        } catch (Exception e) {
        }
    }

    public void validateErrorMessageByPartialText(String partialText, String expectedText) {
        try {
            By errorLocator = By.xpath("//*[contains(text(),'" + partialText + "')]");
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            String actualText = errorElement.getText().trim();

            org.testng.Assert.assertEquals(actualText, expectedText, "Toast message mismatch!");
        } catch (Exception e) {
            org.testng.Assert.fail("Failed to validate error message for partial text: '" + partialText + "' - " + e.getMessage());
        }
        waitFor(2);
    }

    public void safeClick(By b) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // Use BasePage click which already does waits
            clickOnElement(b);
        } catch (Exception e) {
            // fallback to JS click if normal click fails
            WebElement el = retryGetElement(b);
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);
            js.executeScript("arguments[0].click();", el);
        }
    }

    public void safeClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            js.executeScript("arguments[0].click();", element);
        }
    }

    public WebElement retryGetElement(By locators) {
        try {
            return driver.findElement(locators);
        } catch (StaleElementReferenceException se) {
            // single retry
            wait.withTimeout(Duration.ofSeconds(2));
            try {
                return driver.findElement(locators);
            } finally {
                wait.withTimeout(Duration.ofSeconds(30));
            }
        }
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }


    public String textOf(WebElement element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public List<String> uniqueTextsFromElements(By element) {
        return findAll(element).stream()
                .map(this::textOf)
                .filter(s -> !s.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }

    public void hoverOnElement(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        try {
            actions.moveToElement(element).build().perform();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true}));",
                    element
            );
        }
    }

    public void scrollAndClickUsingJS(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            element.click();
        } catch (Exception e) {
            System.out.println("Failed to scroll and click using JS for locator: " + locator);
            e.printStackTrace();
        }
    }

    public void scrollIntoElementUsingJS(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", locator);
        } catch (Exception e) {
            System.out.println("Failed to scroll and click using JS for locator: " + locator);
            e.printStackTrace();
        }
    }

    public void waitFor(double i) {
        long j = (long) (i * 1000);
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateElementText(By locator, String expectedText) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        org.testng.Assert.assertTrue(element.isDisplayed(), "Element is not visible");
        org.testng.Assert.assertEquals(element.getText().trim(), expectedText, "Text validation failed");
    }

    public String getValue(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public double getNumericValue(By locator) {
        String text = getValue(locator);
        return Double.parseDouble(
                text.replaceAll("[^0-9.]", "")
        );
    }

    public void validateElements(By locator) {
        try {
            WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            Assert.assertTrue(searchElement.isDisplayed(), "Search field is not displayed");

        } catch (Exception e) {
            Assert.fail("Search field validation failed - " + e.getMessage());
        }
    }

    public void switchToWindowByIndex(int index) {

        List<String> windows = new ArrayList<>(driver.getWindowHandles());

        if (index < windows.size()) {
            driver.switchTo().window(windows.get(index));
        } else {
            throw new RuntimeException("Window index not found: " + index);
        }
    }


}
