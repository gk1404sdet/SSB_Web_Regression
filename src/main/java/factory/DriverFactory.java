package factory;

import constants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private DriverFactory() {}

    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            initDriver();
        }
        return tlDriver.get();
    }

    public static void initDriver() {

        String browser = System.getProperty("browser", Browser.CHROME.name());
        String mode = System.getProperty("browserMode", "normal");

        WebDriver driver;

        switch (Browser.valueOf(browser.toUpperCase())) {

            case CHROME -> {
                ChromeOptions options = new ChromeOptions();

                if (mode.equalsIgnoreCase("headless")) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }

                driver = new ChromeDriver(options);
            }

            case FIREFOX -> {
                FirefoxOptions options = new FirefoxOptions();

                if (mode.equalsIgnoreCase("headless")) {
                    options.addArguments("--headless");
                }

                driver = new FirefoxDriver(options);
            }

            default -> throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        tlDriver.set(driver);
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
