package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {
        if (browser == null || browser.isEmpty()) {
            browser = System.getProperty("browser", "chrome");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                // Disable notifications and pop-ups via Chrome preferences
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2); // 2 = block
                prefs.put("profile.default_content_setting_values.popups", 0);       // 0 = block
                chromeOptions.setExperimentalOption("prefs", prefs);

                // Optional: headless mode
                // chromeOptions.addArguments("--headless=new");

                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                // Disable notifications and pop-ups
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                firefoxOptions.addPreference("dom.disable_open_during_load", true);
                firefoxOptions.addPreference("dom.popup_maximum", 0);

                // Optional: headless mode
                // firefoxOptions.addArguments("-headless");

                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            default:
                throw new IllegalArgumentException("Unknown browser: " + browser);
        }

        // Maximize window
        getDriver().manage().window().maximize();
        return getDriver();
    }

    // Get current WebDriver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit WebDriver and remove from ThreadLocal
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
