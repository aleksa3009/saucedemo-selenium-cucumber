package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    // --- locators ---
    private By cartItems = By.cssSelector(".cart_item");
    private By itemName = By.cssSelector(".inventory_item_name");
    private By removeButton = By.tagName("button");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");

    // --- actions ---

    // Get all product names currently in the cart
    public List<String> getCartItemNames() {
        waitForVisibility(cartItems);
        return driver.findElements(cartItems)
                .stream()
                .map(item -> item.findElement(itemName).getText())
                .collect(Collectors.toList());
    }

    // Remove a product from the cart by name
    public void removeItemByName(String name) {
        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            if (item.findElement(itemName).getText().equals(name)) {
                item.findElement(removeButton).click();
                return;
            }
        }
        throw new RuntimeException("Cart item not found to remove: " + name);
    }

    // Check if a product exists in the cart
    public boolean isProductInCart(String productName) {
        return driver.findElements(cartItems)
                .stream()
                .anyMatch(item -> item.findElement(itemName).getText().equals(productName));
    }

    // Check if the cart is empty
    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    // Click the Checkout button
    public void clickCheckout() {
        click(checkoutButton);
    }

    // Click the Continue Shopping button
    public void clickContinueShopping() {
        click(continueShoppingButton);
    }
}
