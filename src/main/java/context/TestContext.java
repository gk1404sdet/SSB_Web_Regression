package context;

import io.cucumber.java.Scenario;
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

}
