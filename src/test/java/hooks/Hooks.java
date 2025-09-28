package hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigUtil;
import utils.DriverFactory;
import utils.ExtentTestManager;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        // Read browser from system property or fallback to config
        String browser = System.getProperty("browser", ConfigUtil.getBrowser());
        logger.info("Before scenario: {} - browser: {}", scenario.getName(), browser);

        // Initialize driver and navigate to base URL
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(ConfigUtil.getBaseUrl());

        // Start ExtentTest for this scenario
        ExtentTestManager.startTest(scenario.getName(), scenario.getId());
        ExtentTestManager.getTest().info("Starting scenario: " + scenario.getName()); // log start
    }

    @After
    public void afterScenario(Scenario scenario) {
        // Attach screenshot if scenario failed
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot-" + scenario.getName());
                logger.error("Scenario failed: {} - screenshot attached", scenario.getName());

                // Add screenshot path to ExtentTest if saved via ScreenshotUtil
                String path = ExtentTestManager.getAndRemoveScreenShotPath();
                if (path != null) {
                    ExtentTestManager.getTest().fail("Scenario failed. Screenshot:")
                            .addScreenCaptureFromPath(path);
                } else {
                    ExtentTestManager.getTest().fail("Scenario failed (no screenshot available)");
                }

            } catch (Exception e) {
                logger.error("Failed to capture screenshot: {}", e.getMessage());
            }
        } else {
            ExtentTestManager.getTest().pass("Scenario passed");
        }

        // End ExtentTest
        ExtentTestManager.endTest();

        // Quit driver after each scenario
        DriverFactory.quitDriver();
        logger.info("After scenario: {}", scenario.getName());
    }
}
