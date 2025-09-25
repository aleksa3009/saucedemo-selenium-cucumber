package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

// Utility class for capturing screenshots on test failure.
public class ScreenshotUtil {

    /**
     * Captures a screenshot and saves it under /screenshots/ with timestamp.
     * @param driver WebDriver instance
     * @param testName name of the test method
     */
    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            // Ensure screenshots directory exists
            Files.createDirectories(Paths.get("screenshots"));

            // Build file name with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

            // Capture screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File(filePath);

            Files.copy(srcFile.toPath(), destFile.toPath());
            LoggerUtil.info("Screenshot saved: " + filePath);

        } catch (IOException e) {
            LoggerUtil.error("Failed to save screenshot: " + e.getMessage());
        }
    }
}
