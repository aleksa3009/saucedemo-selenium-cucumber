package smoke;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openHomePage() {

        // Use driver in coordination with FactoryDriver file
        String title = driver.getTitle();

        // Verify that title contain text "Swag Labs"
        Assert.assertTrue(title.contains("Swag Labs"),
                "Title did not contain expected text. Actual: " + title);

        // Verify that username input is visible
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        Assert.assertTrue(usernameInput.isDisplayed(), "Username input is not visible.");

        // Verify that password input is visible
        WebElement passwordInput = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordInput.isDisplayed(), "Password input is not visible.");

        // Verify that login button is displayed and enabled
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not visible.");
        Assert.assertTrue(loginButton.isEnabled(), "Login button is not enabled.");
    }
}
