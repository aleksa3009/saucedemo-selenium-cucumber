package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver using DriverFactory
        driver = DriverFactory.initDriver(System.getProperty("browser", "chrome"));

        // Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize window and navigate to site
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown() {
        // Quit WebDriver
        DriverFactory.quitDriver();
    }
}
