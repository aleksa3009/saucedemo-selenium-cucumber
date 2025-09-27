package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutOverviewPage extends BasePage {
    // Locators for items, prices, subtotal, and finish button
    private By cartItems = By.cssSelector(".cart_item");
    private By itemName = By.cssSelector(".inventory_item_name");
    private By itemPrice = By.cssSelector(".inventory_item_price");
    private By subtotal = By.cssSelector(".summary_subtotal_label");
    private By finishBtn = By.id("finish");

    public CheckoutOverviewPage() { super(); }

    // Returns all product names in the checkout overview
    public List<String> getItemNames() {
        waitForVisibility(cartItems);
        return driver.findElements(itemName).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // Returns all product prices as a list of doubles
    public List<Double> getItemPrices() {
        return driver.findElements(itemPrice).stream()
                .map(e -> Double.parseDouble(e.getText().replace("$","").trim()))
                .collect(Collectors.toList());
    }

    // Extracts subtotal value from UI (without tax/shipping)
    public double getItemTotalFromUI() {
        String text = getText(subtotal).replace("Item total: $", "").trim();
        return Double.parseDouble(text);
    }

    // Clicks the Finish button to complete checkout
    public void clickFinish() {
        click(finishBtn);
    }
}
