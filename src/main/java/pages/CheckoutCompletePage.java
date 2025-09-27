package pages;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {
    // Locators for confirmation header, message and back-home button
    private By header = By.cssSelector(".complete-header");
    private By message = By.cssSelector(".complete-text");
    private By backHome = By.id("back-to-products");

    public CheckoutCompletePage() { super(); }

    // Returns the confirmation header text (e.g. "THANK YOU FOR YOUR ORDER")
    public String getHeaderText() {
        return getText(header);
    }

    // Returns the detailed confirmation message text
    public String getMessageText() {
        return getText(message);
    }

    // Navigates back to the Products page
    public void backToProducts() {
        click(backHome);
    }
}
