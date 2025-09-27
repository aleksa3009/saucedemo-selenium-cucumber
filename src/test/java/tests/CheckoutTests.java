package tests;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void successfulCheckoutTest() {
        // Initialize page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // Login with valid credentials (loginAs performs username+password+click)
        loginPage.loginAs("standard_user", "secret_sauce");

        // Add backpack to cart and navigate to cart
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();

        // Proceed to checkout
        cartPage.clickCheckout();

        // Fill in customer info and continue to next step
        checkoutPage.fillInfo("Aleksa", "Aleksic", "21000");
        checkoutPage.clickContinue();

        // Verify navigation to check out step two
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),
                "Should navigate to checkout-step-two after valid input.");
    }

    @Test
    public void checkoutWithoutFirstName() {
        // Page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // Login and add product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Leave first name empty and attempt to continue
        checkoutPage.fillInfo("", "Aleksic", "21000");
        checkoutPage.clickContinue();

        // Assert error message mentions missing first name
        Assert.assertTrue(checkoutPage.getErrorMessage().contains("First Name is required"),
                "Expected error message for missing First Name.");
    }

    @Test
    public void checkoutWithoutLastName() {
        // Page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // Login and add product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Leave last name empty and attempt to continue
        checkoutPage.fillInfo("Aleksa", "", "21000");
        checkoutPage.clickContinue();

        // Assert error message mentions missing last name
        Assert.assertTrue(checkoutPage.getErrorMessage().contains("Last Name is required"),
                "Expected error message for missing Last Name.");
    }

    @Test
    public void checkoutWithoutPostalCode() {
        // Page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // Login and add product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Leave postal code empty and attempt to continue
        checkoutPage.fillInfo("Aleksa", "Aleksic", "");
        checkoutPage.clickContinue();

        // Assert error message mentions missing postal code
        Assert.assertTrue(checkoutPage.getErrorMessage().contains("Postal Code is required"),
                "Expected error message for missing Postal Code.");
    }

    @Test
    public void cancelCheckoutReturnsToCart() {
        // Page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // Login and add product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Cancel checkout and verify we are back on cart page
        checkoutPage.clickCancel();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "After canceling checkout, user should return to cart page.");
    }

    @Test
    public void completeCheckoutFlow() {
        // Page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // Login and add product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Fill info, continue and finish checkout
        checkoutPage.fillInfo("Aleksa", "Aleksic", "21000");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        // Verify navigation to check out complete page
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"),
                "After finishing checkout, should navigate to checkout-complete page.");
    }
}
