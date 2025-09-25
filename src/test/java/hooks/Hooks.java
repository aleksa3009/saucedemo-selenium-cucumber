package hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigUtil;
import utils.DriverFactory;

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
            } catch (Exception e) {
                logger.error("Failed to capture screenshot: {}", e.getMessage());
            }
        }

        // Quit driver after each scenario
        DriverFactory.quitDriver();
        logger.info("After scenario: {}", scenario.getName());
    }
}
