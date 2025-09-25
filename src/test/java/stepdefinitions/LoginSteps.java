package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.open();
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Login page logo is not displayed");
    }

    @When("the user logs in with {string} and {string}")
    public void the_user_logs_in_with_and(String username, String password) {
        loginPage.loginAs(username, password);
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected_to_the_inventory_page() {
        Assert.assertTrue(loginPage.isAtInventoryPage(), "User is not on inventory page");
    }

    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String username) {
        loginPage.open();
        loginPage.loginAs(username, loginPage.correctPassword);
        Assert.assertTrue(loginPage.isAtInventoryPage(), "User login failed");
    }

    @When("the user opens the burger menu")
    public void the_user_opens_the_burger_menu() {
        loginPage.clickBurgerMenu(); // treba dodati u LoginPage metodu clickBurgerMenu()
    }

    @When("the user clicks the logout link")
    public void the_user_clicks_the_logout_link() {
        loginPage.clickLogout(); // treba dodati u LoginPage metodu clickLogout()
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Login page is not displayed after logout");
    }

    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Error message does not match");
    }

    @Then("the login page title should be visible")
    public void the_login_page_title_should_be_visible() {
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Login page title/logo not visible");
    }

    @Then("the username input field should be visible")
    public void the_username_input_field_should_be_visible() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field not visible");
    }

    @Then("the login button should be visible")
    public void the_login_button_should_be_visible() {
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button not visible or disabled");
    }
}
