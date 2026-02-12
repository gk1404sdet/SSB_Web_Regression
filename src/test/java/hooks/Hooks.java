package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;
import utilities.*;

import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Hooks {

    private final TestContext context;
    private static final AtomicBoolean allureCleaned = new AtomicBoolean(false);
    private static final AtomicBoolean categoriesWritten = new AtomicBoolean(false);

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before(order = 0)
    public void cleanAllureOnce() {
        if (allureCleaned.compareAndSet(false, true)) {
            AllureCleaner.clean();
        }
    }

    @Before(order = 1)
    public void setUp(Scenario scenario) {
        context.driver = DriverFactory.getDriver();
        context.scenario = scenario;

        context.configLoader = new ConfigLoader();
        context.credsLoader = new CredsLoader();

        context.loginPage = new LoginPage(context.driver);
        context.accountPage = new AccountPage(context.driver);
    }

    @Before(order = 2)
    public void writeAllureEnv() {
        AllureEnvironmentWriter.createEnvironment();
    }

    // ---------- ALLURE CATEGORIES ----------
    @Before(order = 3)
    public void writeAllureCategories() {
        if (categoriesWritten.compareAndSet(false, true)) {
            AllureCategoryWriter.createCategories();
        }
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
    // ---------- ALLURE STEP SCREENSHOT ----------
    @AfterStep
    public void attachScreenshot(Scenario scenario) {
        try {
            if (scenario.isFailed() && context.driver != null) {
                Allure.addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        new ByteArrayInputStream(
                                ((TakesScreenshot) context.driver)
                                        .getScreenshotAs(OutputType.BYTES)
                        ),
                        ".png"
                );
            }
        } catch (Exception ignored) {}
    }
}
