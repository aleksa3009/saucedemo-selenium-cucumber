package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTests extends BaseTest {

    @Test(description = "Add product to cart and verify it appears in cart")
    public void addProductToCartTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("standard_user", loginPage.correctPassword);

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "Product should be in cart");
    }

    @Test(description = "Remove product from cart and verify it is removed")
    public void removeProductFromCartTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("standard_user", loginPage.correctPassword);

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-bike-light");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.removeItemByName("Sauce Labs Bike Light");
        Assert.assertFalse(cartPage.isProductInCart("Sauce Labs Bike Light"),
                "Product should be removed from cart");
    }

    @Test(description = "Continue shopping button returns to inventory page")
    public void continueShoppingTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("standard_user", loginPage.correctPassword);

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-onesie");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.clickContinueShopping();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Should navigate back to inventory page");
    }
}
