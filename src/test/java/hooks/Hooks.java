package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {
        context.driver = DriverFactory.getDriver();
        context.scenario = scenario;

        context.configLoader = new ConfigLoader();
        context.credsLoader = new CredsLoader();

        context.loginPage = new LoginPage(context.driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot =
                    ((TakesScreenshot) context.driver)
                            .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        DriverFactory.quitDriver();
    }
}
