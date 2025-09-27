package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutOverviewTests extends BaseTest {

    @Test
    public void verifyItemNamesAndPricesOnOverview() {
        // Initialize page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();

        // Login and add a product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Retrieve item names and prices from overview
        var names = overviewPage.getItemNames();
        var prices = overviewPage.getItemPrices();

        // Assertions
        Assert.assertTrue(names.contains("Sauce Labs Backpack"), "Overview should contain added product.");
        Assert.assertTrue(prices.get(0) > 0, "Price should be greater than 0.");
    }

    @Test
    public void verifyItemTotalMatchesSumOfPrices() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();

        // Login and add product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Calculate sum of item prices
        var prices = overviewPage.getItemPrices();
        double sum = prices.stream().mapToDouble(Double::doubleValue).sum();

        // Compare with subtotal displayed in UI
        double subtotalUI = overviewPage.getItemTotalFromUI();
        Assert.assertEquals(subtotalUI, sum, 0.01, "UI subtotal should match sum of item prices.");
    }
}
