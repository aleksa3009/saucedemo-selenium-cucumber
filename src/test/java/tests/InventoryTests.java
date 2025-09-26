package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests extends BaseTest {

    @Test
    public void inventoryPageDisplaysAllProductsTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        // login as standard user
        loginPage.loginAs("standard_user", "secret_sauce");

        // verify products are displayed
        Assert.assertFalse(inventoryPage.getAllProductNames().isEmpty(), "Inventory should display products");
    }

    @Test
    public void addMultipleProductsToCartTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.loginAs("standard_user", "secret_sauce");

        // add two products
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-bike-light");

        // verify cart badge count
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), 2, "Cart badge should show 2 items");
    }

    @Test
    public void productButtonTextChangesAfterAddingToCartTest() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.loginAs("standard_user", "secret_sauce");

        String productName = "Sauce Labs Backpack";
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");

        // verify button text changes to 'Remove'
        String buttonText = inventoryPage.getButtonTextByProductName(productName);
        Assert.assertEquals(buttonText, "Remove", "Button text should change to 'Remove' after adding product");
    }
}
