package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutPage extends BasePage {

    public final By emptyBag = By.xpath("//p[contains(text(),'Your Bag Feels Too Light!')]");
    private final By proceedToCheckout = By.xpath("//button[contains(text(),'Proceed to Checkout')]");
    private final By mrpProduct =  By.xpath("//p[contains(text(), 'Total MRP')]/following-sibling::p");
    private final By discountProduct = By.xpath("//p[contains(text(), 'Offer Discount')]/following-sibling::p");
    private final By savingsProduct = By.xpath("//div[contains(text(), 'Your Total Savings')]/following-sibling::p");
    private final By deliveryFeeProduct = By.xpath("//div[contains(text(), 'Delivery Fee')]/following-sibling::p");
    private final By totalFeeProduct =  By.xpath("//p[normalize-space()='Total Amount']/following-sibling::p[contains(text(),'₹')]");
    private final By continueButton = By.xpath("//button[contains(text(), 'continue')]");
    private final By cod = By.xpath("//p[contains(text(),'Select COD')]");
    private final By placeOrder = By.xpath("//p[contains(text(),'Place Order')]");
    public final By orderSuccess = By.xpath("//p[contains(text(),'Order Placed Successfully')]");
    private final By orderDetailsContainer = By.xpath("//div[@class='MuiBox-root css-op4je4']");
    private final By rows = By.xpath("//div[@class='MuiBox-root css-q73mck']");
    private final By continueShopping = By.xpath("(//p[contains(text(),'Continue Shopping')])[1]");
    private final By upi = By.xpath("//p[contains(text(),'Add New UPI Id')]");
    private final By editUpi = By.xpath("//input[@placeholder='Enter UPI ID Here']");
    private final By verify = By.xpath("//button[contains(text(),'VERIFY')]");



    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnProceedToCheckout() {
        isElementPresent(proceedToCheckout);
        safeClick(proceedToCheckout);
    }
    public boolean validateEmptyBag() {
        try {
            List<WebElement> emptyBagMessage = driver.findElements(emptyBag);
            return emptyBagMessage.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public Map<String, Double> getPriceDetails() {

        Map<String, Double> priceMap = new HashMap<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        double mrp = 0, discount = 0, delivery = 0, total = 0;

        try {
            WebElement mrpElem = wait.until(ExpectedConditions.visibilityOfElementLocated(mrpProduct));
            mrp = Double.parseDouble(mrpElem.getText().replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        try {
            WebElement discountElem = driver.findElement(discountProduct);
            discount = Double.parseDouble(discountElem.getText().replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        try {
            WebElement deliveryElem = driver.findElement(deliveryFeeProduct);
            String deliveryText = deliveryElem.getText().trim();
            delivery = deliveryText.equalsIgnoreCase("Free") ? 0
                    : Double.parseDouble(deliveryText.replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        try {
            WebElement totalElem = driver.findElement(totalFeeProduct);
            total = Double.parseDouble(totalElem.getText().replaceAll("[^\\d.]", ""));
        } catch (Exception ignored) {}

        priceMap.put("MRP", mrp);
        priceMap.put("Discount", discount);
        priceMap.put("DeliveryFee", delivery);
        priceMap.put("Total", total);

        return priceMap;
    }
    public boolean validatePriceDetails(Map<String, Double> priceMap) {

        double mrp = priceMap.get("MRP");
        double discount = priceMap.get("Discount");
        double delivery = priceMap.get("DeliveryFee");
        double total = priceMap.get("Total");

        if (mrp <= 0 || total <= 0) return false;

        double expected = mrp - discount + delivery;
        return Math.abs(total - expected) < 0.1;
    }


    public void clickOnContinueButton() {
        isElementPresent(continueButton);
        safeClick(continueButton);
    }
    public void selectingTheCODOption() {
        isElementPresent(cod);
        safeClick(cod);
    }
    public void clickOnPlaceOrder() {
        isElementPresent(placeOrder);
        safeClick(placeOrder);
    }
    public void printOrderDetails() {

        WebElement container = driver.findElement(orderDetailsContainer);
        List<WebElement> details = container.findElements(rows);

        for (WebElement row : details) {
            List<WebElement> texts = row.findElements(By.xpath(".//p"));
            if (texts.size() == 2) {
                String label = texts.get(0).getText().trim();
                String value = texts.get(1).getText().trim();
                System.out.println(label + " : " + value);
            }
        }
    }
    public void clickOnContinueShopping() {
        isElementPresent(continueShopping);
        safeClick(continueShopping);
    }
    public void selectingTheUPIOption() {
        isElementPresent(upi);
        safeClick(upi);
    }
    public void enterTheUPIId(String upi) {
        isElementPresent(editUpi);
        enterTextOnElement(editUpi, upi);
    }
    public void clickOnVerify() {
        isElementPresent(verify);
        safeClick(verify);
    }
}
