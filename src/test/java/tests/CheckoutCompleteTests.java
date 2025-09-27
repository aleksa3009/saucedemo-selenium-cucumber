package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutCompleteTests extends BaseTest {

    @Test
    public void verifyCheckoutCompletionMessage() {
        // Initialize page objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
        CheckoutCompletePage completePage = new CheckoutCompletePage();

        // Login and add product
        loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.openCart();
        cartPage.clickCheckout();

        // Continue from overview and finish
        overviewPage.clickFinish();

        // Assertions for completion page
        String header = completePage.getHeaderText();
        String message = completePage.getMessageText();

        Assert.assertTrue(header.contains("THANK YOU"), "Completion header should confirm order.");
        Assert.assertTrue(message.length() > 0, "Completion message should not be empty.");

        // Go back to products page
        completePage.backToProducts();
        Assert.assertTrue(inventoryPage.getAllProductNames().size() > 0,
                "Should return to inventory page with products listed.");
    }
}
