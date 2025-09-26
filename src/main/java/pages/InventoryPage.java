package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    // Locators
    private By shoppingCartLink = By.className("shopping_cart_link");
    private By productNames = By.cssSelector(".inventory_item_name");
    private By productPrices = By.cssSelector(".inventory_item_price");

    // Open inventory page
    public void openInventoryPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    // Add product to cart by id
    public void addProductToCart(String productId) {
        click(By.id(productId));  // uses protected click from BasePage
    }

    // Open cart
    public void openCart() {
        click(shoppingCartLink); // uses protected click from BasePage
    }

    // Get all product names
    public List<String> getAllProductNames() {
        waitForVisibility(productNames); // uses protected waitForVisibility from BasePage
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // Get all product prices
    public List<String> getAllProductPrices() {
        waitForVisibility(productPrices); // uses protected waitForVisibility from BasePage
        return driver.findElements(productPrices)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // Get cart badge count
    public int getCartBadgeCount() {
        try {
            return Integer.parseInt(driver.findElement(By.className("shopping_cart_badge")).getText());
        } catch (Exception e) {
            return 0;
        }
    }

    // Get button text by product name
    public String getButtonTextByProductName(String productName) {
        return driver.findElement(By.xpath(
                        "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"))
                .getText();
    }
}
