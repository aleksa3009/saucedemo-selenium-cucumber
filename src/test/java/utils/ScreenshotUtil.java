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

/**
 * Utility class for taking screenshots.
 * Can be used for capturing the screen on test failure.
 */
public class ScreenshotUtil {

    /**
     * Takes a screenshot and saves it to /screenshots/ folder with timestamp.
     * @param driver The WebDriver instance
     * @param name   Name to use for the screenshot file
     */
    public static void takeScreenshot(WebDriver driver, String name) {
        // Create screenshots directory if it doesn't exist
        try {
            Files.createDirectories(Paths.get("screenshots"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Format timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Build file path
        String filePath = "screenshots/" + name + "_" + timestamp + ".png";

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
