package utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

// Utility class for common assertions
public class AssertUtil {

    // Assert element is visible
    public static void assertElementVisible(WebElement element, String message) {
        Assert.assertTrue(element.isDisplayed(), message);
    }

    // Assert element text contains expected value
    public static void assertTextContains(WebElement element, String expectedText) {
        String actual = element.getText();
        Assert.assertTrue(actual.contains(expectedText),
                "Expected text: '" + expectedText + "' not found in element. Actual: '" + actual + "'");
    }
}
