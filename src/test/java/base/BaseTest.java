package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigUtil;
import utils.DriverFactory;
import utils.LoggerUtil;
import utils.WaitUtil;
import utils.ScreenshotUtil;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WaitUtil waitUtil;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional String browser) {
        // Get browser parameter or fallback to config.properties
        String selectedBrowser = (browser != null && !browser.isEmpty())
                ? browser
                : ConfigUtil.getBrowser();

        LoggerUtil.info("Starting test in browser: " + selectedBrowser);

        // Initialize WebDriver from DriverFactory
        driver = DriverFactory.initDriver(selectedBrowser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigUtil.getImplicitWait()));

        // Initialize explicit waits
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigUtil.getExplicitWait()));
        waitUtil = new WaitUtil(driver);

        // Navigate to base URL from config.properties
        String baseUrl = ConfigUtil.getBaseUrl();
        LoggerUtil.info("Opening base URL: " + baseUrl);
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        // Capture screenshot on test failure
        if (!result.isSuccess()) {
            LoggerUtil.error("Test failed: " + result.getName());
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }

        // Quit WebDriver
        LoggerUtil.info("Closing browser");
        DriverFactory.quitDriver();
    }
}
