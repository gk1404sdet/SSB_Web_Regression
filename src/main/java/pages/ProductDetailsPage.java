package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.sound.midi.SysexMessage;
import java.time.Duration;
import java.util.*;

public class ProductDetailsPage extends BasePage {

    // ---------- Locators ----------

    private final By shareWithFriendsBtn = By.xpath("//p[contains(text(), 'Share it with friends')]");
    private final By facebookBtn = By.xpath("//button[contains(text(),'FACEBOOK')]");
    private final By whatsappBtn = By.xpath("//button[contains(text(),'WHATSAPP')]");
    private final By pinterestBtn = By.xpath("//button[contains(text(),'PINTEREST')]");
    private final By emailBtn = By.xpath("//button[contains(text(),'EMAIL')]");
    public final By productList = By.xpath("(//div[@data-item-type='ProdctSCCard'])[1]");
    public final By customerAlsoBoughtProduct = By.xpath("(//p[contains(text(),'CUSTOMERS ALSO BOUGHT')]/following::div[@data-item-type='ProdctSCCard'])[1]");
    public final By customersAlsoBought = By.xpath("//p[contains(text(),'CUSTOMERS ALSO BOUGHT')]");
    public final By moreFromTheBrand = By.xpath("//p[contains(text(),'MORE FROM THE BRAND')]");
    public final By reviewAndRating = By.xpath("//p[contains(text(),'Review & Ratings')]");
    private final By viewSimilarProductsIcon = By.xpath("(//div[contains(@class,'MuiBox-root css-12m2grd')]//*[name()='svg'])[1]");
    private final By addToBagSimilarProductsIcon = By.xpath("//p[normalize-space()='SIMILAR PRODUCTS']/following::button[normalize-space()='Add To Bag']");
    private final By addToBagCustomersAlsoBoughtIcon = By.xpath("//p[normalize-space()='CUSTOMERS ALSO BOUGHT']/following::button[normalize-space()='Add To Bag']");
    private final By addToFavouriteSimilarProductsIcon = By.xpath("(//p[normalize-space()='SIMILAR PRODUCTS']/following::div[@class='MuiGrid-root css-shd5b'])[1]");
    private final By addToFavouriteCustomersAlsoBoughtIcon = By.xpath("(//p[normalize-space()='CUSTOMERS ALSO BOUGHT']/following::div[@class='MuiGrid-root css-shd5b'])[1]");
    private final By ProductAddedToCartMsg = By.xpath("//p[contains(text(),'Product successfully added to your cart')]");
    private final By writeAReviewBtn = By.xpath("//button[contains(text(),'WRITE A REVIEW')]");
    private final By addPhotosPopup = By.xpath("//p[contains(text(),'ADD PHOTOS')]");
    private final By ratingForThisProduct = By.xpath("//p[contains(text(),'Your rating for this product')]");
    private final By writeAReviewPopup = By.xpath("//p[contains(text(),'Write a review')]");
    private final By threeStarRating = By.xpath("//span[@class='MuiRating-root MuiRating-sizeMedium css-my98p3']/label[3]");
    private final By reviewTitleTxtBox = By.xpath("//input[@placeholder='Review title']");
    private final By reviewDescriptionTxtBox = By.xpath("//textarea[@placeholder='Review description']");
    private final By AddReviewBtn = By.xpath("//button[contains(text(),'Add Review')]");
    private final By reviewSubmittedMessage = By.xpath("//p[contains(text(),'Thanks for Sharing Your Review!')]");
    private final By cartFirstProductName = By.xpath("(//div[@data-item-type='CartProductCard']//p[contains(@class,'MuiTypography-body1')])[1]");
    private final By productNamePDP = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 css-y8yexr']");
    private final By firstsProductNamePLP = By.xpath("(//p[@class='css-12anm3s'])[1]");
    private final By uploadPhotoInput = By.xpath("//input[@id='file']");
    private final By uploadedThumbnail = By.xpath("//img[@alt='review_img']");
    private final By authentic100percent = By.xpath("//p[contains(text(),'100% Authentic')]");
    private final By fastDelivery = By.xpath("//p[contains(text(),'Fast delivery')]");
    private final By freeShipping = By.xpath("//p[contains(text(),'Free shipping')]");
    private final By productDescription = By.xpath("//p[contains(text(),'Product Description')]");
    private final By productAdditionalDetails = By.xpath("//p[contains(text(),'Additional Details')]");
    private final By productHowToUse = By.xpath("//p[contains(text(),'How to Use')]");
    private final By productAboutTheBrand = By.xpath("//p[contains(text(),'About the Brand')]");
    private final By productDescriptionViewMore = By.xpath("(//p[contains(text(),'Product Description')]/following::span[contains(text(),'View More')])[1]");
    private final By productDescriptionViewLess = By.xpath("(//p[contains(text(),'Product Description')]/following::span[contains(text(),'View Less')])[1]");
    private final By productHowToUseViewMore = By.xpath("(//p[contains(text(),'How to Use')]/following::span[contains(text(),'View More')])[1]");
    private final By productHowToUseViewLess = By.xpath("(//p[contains(text(),'How to Use')]/following::span[contains(text(),'View Less')])[1]");
    private final By productAboutTheBrandViewMore = By.xpath("(//p[contains(text(),'About the Brand')]/following::span[contains(text(),'View More')])[1]");
    private final By productAboutTheBrandViewLess = By.xpath("(//p[contains(text(),'About the Brand')]/following::span[contains(text(),'View Less')])[1]");
    private final By goToBagPDP = By.xpath("//p[contains(text(),'Go To Bag')]");
    private final By quantityIncreaseBtn = By.xpath("(//div[@class='MuiBox-root css-mq1otb']/button[2])[1]");
    private final By quantityDecreaseBtn = By.xpath("(//div[@class='MuiBox-root css-mq1otb']/button[1])[1]");
    private final By productQuantityBox = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1j74sq2'])[1]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Common Actions ----------
    public boolean validateShareOptionsComponentsByText(List<String> expectedSections) {

        isElementPresent(shareWithFriendsBtn);
        List<By> expectedComponents = Arrays.asList(
                shareWithFriendsBtn,
                facebookBtn,
                whatsappBtn,
                pinterestBtn,
                emailBtn

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

    public void clickOnViewSimilarProductsIconPDP() {

        isElementPresent(viewSimilarProductsIcon);
        safeClick(viewSimilarProductsIcon);
        waitFor(1);
    }

    public List<String> getFirstFourProductNames() {

        List<String> productNames = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            By productNameBy = By.xpath("(//p[@class='css-6r9hbw'])[" + i + "]");
            WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameBy));
            String productName = productElement.getText().trim();
            productNames.add(productName);
        }
        return productNames;
    }

    public void clickOnAddToCartSimilarProductPDP() {

        isElementPresent(addToBagSimilarProductsIcon);
        safeClick(addToBagSimilarProductsIcon);
        waitFor(2);
    }

    public void clickOnAddToFavouriteSimilarProductPDP() {

        waitFor(5);
        isElementPresent(addToFavouriteSimilarProductsIcon);
        safeClick(addToFavouriteSimilarProductsIcon);
        waitFor(2);
    }

    public void clickOnAddToFavouriteCustomersAlsoBoughtPDP() {

        waitFor(5);
        isElementPresent(addToFavouriteCustomersAlsoBoughtIcon);
        safeClick(addToFavouriteCustomersAlsoBoughtIcon);
        waitFor(2);
    }

    public void moveToProduct() {

        isElementPresent(productList);
        moveToElement(productList);
    }

    public void moveToSimilarProductPDP() {

        try {
            hoverOnElement(productList);
            if (isElementPresent(addToBagSimilarProductsIcon)) {
                safeClick(addToBagSimilarProductsIcon);
            }
        } catch (Exception e) {}
    }

    public void moveToCustomersAlsoBoughtPDP() {

        try {
            hoverOnElement(customerAlsoBoughtProduct);
            if (isElementPresent(addToBagCustomersAlsoBoughtIcon)) {
                safeClick(addToBagCustomersAlsoBoughtIcon);
            }
        } catch (Exception e) {}
    }

    public void scrollSimilarProductsProductPDP() {

        scrollIntoElementUsingJS(customersAlsoBought);
        waitFor(2);
    }

    public void scrollCustomersAlsoBoughtProductPDP() {

//        scrollIntoElementUsingJS(moreFromTheBrand);
//        scrollIntoElementUsingJS(moreFromTheBrand);
//        scrollToElement(moreFromTheBrand);
        scrollTillElement(moreFromTheBrand);
//        scrollEndOfPage();
        waitFor(2);
    }

    public void ValidateProductAddedToCart() {

        isWebElementDisplayed(ProductAddedToCartMsg);
    }

    public void scrollToWriteAReviewPDP() {

        scrollAndClickUsingJS(writeAReviewBtn);
        waitFor(2);
    }

    public void clickOnRatingsStar() {

        isElementPresent(threeStarRating);
        safeClick(threeStarRating);
    }

    public boolean validateWriteAReviewComponentsByText(List<String> expectedSections) {

        isElementPresent(writeAReviewPopup);
        List<By> expectedComponents = Arrays.asList(
                writeAReviewPopup,
                addPhotosPopup,
                ratingForThisProduct

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

    public void enterReviewTitle(String str) {

        enterKeywordOnElement(reviewTitleTxtBox, str);
    }

    public void enterReviewDescription(String str) {

        enterKeywordOnElement(reviewDescriptionTxtBox, str);
    }

    public void clickOnAddReviewBtn() {

        isElementPresent(AddReviewBtn);
        safeClick(AddReviewBtn);
        waitFor(10);
    }

    public void validateReviewSubmittedPopup() {

        isElementPresent(reviewSubmittedMessage);
        validateErrorMessageByPartialText("Thanks for Sharing Your Review!", "Thanks For Sharing Your Review!");
    }

    public String getFirstCartProductName() {

        WebElement productNameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(cartFirstProductName));

        String productName = productNameElement.getText().trim();
        System.out.println("First Cart Product Name: " + productName);

        return productName;
    }

    public String getProductNamePDP() {

        WebElement productNameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productNamePDP));

        String productName = productNameElement.getText().trim();
        System.out.println("Product Name from PDP: " + productName);

        return productName;
    }

    public String getProductNamePDPTrimmedVersion() {

        WebElement productNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productNamePDP));

        String fullProductName = productNameElement.getText().trim();
        System.out.println("Product Name from PDP: " + fullProductName);

        String trimmedProductName = fullProductName.split("-")[0].trim();
        System.out.println("Trimmed Product Name: " + trimmedProductName);

        return trimmedProductName;
    }

    public String getFirstProductNamePLP() {

        WebElement productNameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstsProductNamePLP));

        String productName = productNameElement.getText().trim();
        return productName;
    }

    public void uploadReviewPhoto() {

        String filePath = System.getProperty("user.dir") + "/review_photo.jpg";

        System.out.println(filePath);

        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(uploadPhotoInput));
        uploadInput.sendKeys(filePath);
        waitFor(2);
        Assert.assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedThumbnail))
                        .isDisplayed(),
                "Uploaded review photo is not visible"
        );
    }

    public boolean validatePDPTrustedBadgesByText(List<String> expectedSections) {
        isElementPresent(authentic100percent);
        List<By> expectedComponents = Arrays.asList(
                authentic100percent,
                fastDelivery,
                freeShipping

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

    public boolean validatePDPAdditionalDetailsByText(List<String> expectedSections) {
        isElementPresent(productAdditionalDetails);
        List<By> expectedComponents = Arrays.asList(
                productAdditionalDetails,
                productDescription,
                productHowToUse,
                productAboutTheBrand,
                productDescriptionViewMore,
                productHowToUseViewMore,
                productAboutTheBrandViewMore

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

    public void scrollToProductDesViewMorePDP() {

        scrollTillElement(productDescriptionViewMore);
    }

    public void clickOnViewMoreProdDescription() {

        scrollTillElement(productDescriptionViewMore);
        isElementPresent(productDescriptionViewMore);
        safeClick(productDescriptionViewMore);
    }

    public void clickOnViewLessProdDescription() {

        scrollTillElement(productDescriptionViewLess);
        isElementPresent(productDescriptionViewLess);
        safeClick(productDescriptionViewLess);
    }

    public void clickOnViewMoreHowtoUse() {

        scrollTillElement(productHowToUseViewMore);
        isElementPresent(productHowToUseViewMore);
        safeClick(productHowToUseViewMore);
    }

    public void clickOnViewLessHowToUse() {

        scrollTillElement(productHowToUseViewLess);
        isElementPresent(productHowToUseViewLess);
        safeClick(productHowToUseViewLess);
    }

    public void clickOnViewMoreAboutTheBrand() {

        scrollTillElement(productAboutTheBrandViewMore);
        isElementPresent(productAboutTheBrandViewMore);
        safeClick(productAboutTheBrandViewMore);
    }

    public void clickOnViewLessAboutTheBrand() {

        scrollTillElement(productAboutTheBrandViewLess);
        isElementPresent(productAboutTheBrandViewLess);
        safeClick(productAboutTheBrandViewLess);
    }

    public void waitFor() {
        waitFor(20);
    }

    public void meeshoLaunch() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");

        options.addArguments("user-data-dir=/Users/apple/Library/Application Support/Google/Chrome");
        options.addArguments("profile-directory=Default");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.meesho.com/");

        waitFor(10);
    }

    public void clickOnGoToBagPDP() {

        isElementPresent(goToBagPDP);
        safeClick(goToBagPDP);
    }

    public String getProductQuantityCount() {

        WebElement productQuantityCount =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityBox));

        String quantityCount = productQuantityCount.getText().trim();
        System.out.println("Product Name from PDP: " + quantityCount);

        return quantityCount;
    }

    public void validateQuantityIncrementCount(String firstProductQuantityCountBefore,String firstProductQuantityCountAfterIncrement) {

        int before = Integer.parseInt(firstProductQuantityCountBefore.trim());
        int after = Integer.parseInt(firstProductQuantityCountAfterIncrement.trim());
        Assert.assertTrue(before < after, "Before quantity count is not greater than after incrementing quantity count"
        );
    }

    public void validateQuantityDecrementCount(String firstProductQuantityCountAfterIncrement,String firstProductQuantityCountAfterDecrement) {

        int increasedCount = Integer.parseInt(firstProductQuantityCountAfterIncrement.trim());
        int decreasedCount = Integer.parseInt(firstProductQuantityCountAfterDecrement.trim());
        Assert.assertTrue(decreasedCount < increasedCount, "decremented quantity count is greater than incremented quantity count"
        );
    }

}
