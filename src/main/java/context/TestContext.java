package context;

import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Product;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class TestContext {
    public WebDriver driver;
    public Scenario scenario;

    public ConfigLoader configLoader;
    public CredsLoader credsLoader;

    public LoginPage loginPage;
    public AccountPage accountPage;
    public WishlistPage wishlistPage;
    public HomePage homePage;
    public CheckoutPage checkoutPage;
    public ProductDetailsPage pdp;
    public ProductListingPage plp;
    public HeaderPage headerPage;
}
