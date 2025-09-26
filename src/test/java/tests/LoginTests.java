package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.loginAs("standard_user", loginPage.correctPassword);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login failed for standard_user");
    }

    @Test
    public void lockedOutUserCannotLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.loginAs("locked_out_user", loginPage.correctPassword);

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("locked out"),
                "Expected locked out error message not displayed.");
    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.open();
        loginPage.loginAs(loginPage.acceptedUsernames[0], loginPage.correctPassword);
        Assert.assertTrue(loginPage.isAtInventoryPage(), "Login failed");

        loginPage.clickBurgerMenu();
        loginPage.clickLogout();

        Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo should be displayed after logout");
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field should be displayed after logout");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field should be displayed after logout");
    }

    @Test
    public void loginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.loginAs("invalid_user", loginPage.correctPassword);

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match any user"),
                "Expected error message not displayed for invalid username.");
    }

    @Test
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.loginAs(loginPage.acceptedUsernames[0], "wrong_password");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match any user"),
                "Expected error message not displayed for invalid password.");
    }

    @Test
    public void loginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.loginAs("", loginPage.correctPassword);

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username is required"),
                "Expected error message not displayed for empty username.");
    }

    @Test
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.loginAs(loginPage.acceptedUsernames[0], "");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Password is required"),
                "Expected error message not displayed for empty password.");
    }
}
