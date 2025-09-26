package stepdefinitions;

import io.cucumber.java.en.*;
import pages.InventoryPage;

import java.util.List;

public class InventorySteps {

    private InventoryPage inventoryPage = new InventoryPage();

    @Given("the user is on the inventory page")
    public void the_user_is_on_the_inventory_page() {
        inventoryPage.openInventoryPage();
    }

    @When("the user adds {string} to the cart")
    public void the_user_adds_to_the_cart(String productId) {
        inventoryPage.addProductToCart(productId);
    }

    @When("the user adds the following products to the cart:")
    public void the_user_adds_the_following_products_to_the_cart(io.cucumber.datatable.DataTable dataTable) {
        List<String> products = dataTable.asList();
        for (String p : products) {
            inventoryPage.addProductToCart(p);
        }
    }

    @Then("the cart badge should display {string}")
    public void the_cart_badge_should_display(String expectedCount) {
        int actual = inventoryPage.getCartBadgeCount();
        if (actual != Integer.parseInt(expectedCount)) {
            throw new RuntimeException("Expected cart badge: " + expectedCount + ", found: " + actual);
        }
    }

    @Then("the button for {string} should display text {string}")
    public void the_button_for_should_display_text(String productName, String expectedText) {
        String actual = inventoryPage.getButtonTextByProductName(productName);
        if (!actual.equals(expectedText)) {
            throw new RuntimeException("Expected button text: " + expectedText + ", found: " + actual);
        }
    }

    @Then("the number of products displayed should be {int}")
    public void the_number_of_products_displayed_should_be(int expectedCount) {
        List<String> products = inventoryPage.getAllProductNames();
        if (products.size() != expectedCount) {
            throw new RuntimeException("Expected " + expectedCount + " products, found: " + products.size());
        }
    }

    @Then("the product names should exactly be:")
    public void the_product_names_should_exactly_be(io.cucumber.datatable.DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<String> actual = inventoryPage.getAllProductNames();
        if (!expected.equals(actual)) {
            throw new RuntimeException("Expected product names: " + expected + ", found: " + actual);
        }
    }

    @Then("the product prices should exactly be:")
    public void the_product_prices_should_exactly_be(io.cucumber.datatable.DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<String> actual = inventoryPage.getAllProductPrices();
        if (!expected.equals(actual)) {
            throw new RuntimeException("Expected product prices: " + expected + ", found: " + actual);
        }
    }
}
