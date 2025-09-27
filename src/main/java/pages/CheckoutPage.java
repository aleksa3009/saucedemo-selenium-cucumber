package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    // --- locators ---
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By finishButton = By.id("finish");

    // --- actions ---

    // Enter first name
    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    // Enter last name
    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    // Enter postal code
    public void enterPostalCode(String postalCode) {
        type(postalCodeField, postalCode);
    }

    // Fill all info at once
    public void fillInfo(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    // Click Cancel button
    public void clickCancel() {
        click(cancelButton);
    }

    // Click Continue button
    public void clickContinue() {
        click(continueButton);
    }

    // Click Finish button
    public void clickFinish() {
        click(finishButton);
    }

    // Get error message text
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    // Check if error message is displayed
    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }
}
