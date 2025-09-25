package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtil;
import utils.DriverFactory;
import utils.WaitUtil;

public class LoginPage {

    private WebDriver driver;
    private WaitUtil waitUtil;

    // Locators
    private By pageTitle = By.className("login_logo");
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessageBox = By.cssSelector("[data-test='error']");
    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    // Constants
    public final String correctPassword = "secret_sauce";

    public final String[] acceptedUsernames = {
            "standard_user",
            "locked_out_user",
            "problem_user",
            "performance_glitch_user",
            "error_user",
            "visual_user"
    };

    // Constructor
    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        this.waitUtil = new WaitUtil(driver);
    }

    // Open login page
    public void open() {
        driver.get(ConfigUtil.getBaseUrl());
    }

    // Enter username
    public void enterUsername(String username) {
        waitUtil.waitForVisibility(usernameInput).clear();
        waitUtil.waitForVisibility(usernameInput).sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        waitUtil.waitForVisibility(passwordInput).clear();
        waitUtil.waitForVisibility(passwordInput).sendKeys(password);
    }

    // Click login button
    public void clickLogin() {
        waitUtil.waitForClickable(loginButton).click();
    }

    // Full login
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Click burger menu
    public void clickBurgerMenu() {
        waitUtil.waitForClickable(burgerMenu).click();
    }

    // Click logout link
    public void clickLogout() {
        waitUtil.waitForClickable(logoutLink).click();
    }

    // Get error message
    public String getErrorMessage() {
        try {
            if (waitUtil.waitForVisibility(errorMessageBox) != null &&
                    waitUtil.waitForVisibility(errorMessageBox).isDisplayed()) {
                return waitUtil.waitForVisibility(errorMessageBox).getText();
            }
        } catch (Exception e) {
            // element not visible
        }
        return "";
    }

    // Page checks
    public boolean isLogoDisplayed() {
        return waitUtil.waitForVisibility(pageTitle).isDisplayed();
    }

    public boolean isLoginButtonEnabled() {
        return waitUtil.waitForVisibility(loginButton).isEnabled();
    }

    public boolean isUsernameFieldDisplayed() {
        return waitUtil.waitForVisibility(usernameInput).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return waitUtil.waitForVisibility(passwordInput).isDisplayed();
    }

    public boolean isAtInventoryPage() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public String getUsernameFieldPlaceholder() {
        return waitUtil.waitForVisibility(usernameInput).getAttribute("placeholder");
    }

    public String getPasswordFieldPlaceholder() {
        return waitUtil.waitForVisibility(passwordInput).getAttribute("placeholder");
    }

    public String getLoginButtonValue() {
        return waitUtil.waitForVisibility(loginButton).getAttribute("value");
    }
}
