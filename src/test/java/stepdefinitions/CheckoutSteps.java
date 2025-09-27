package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;

import java.util.List;

public class CheckoutSteps {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage overviewPage;
    private CheckoutCompletePage completePage;

    public CheckoutSteps() {
        // Initialize all page objects
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        overviewPage = new CheckoutOverviewPage();
        completePage = new CheckoutCompletePage();
    }

    // ----- LOGIN -----
    @Given("the user is logged in as {string}")
    public void user_is_logged_in(String username) {
        loginPage.loginAs(username, "secret_sauce");
        Assert.assertTrue(inventoryPage.getAllProductNames().size() > 0,
                "User should be redirected to inventory page after login.");
    }

    // ----- ADD TO CART -----
    @When("the user adds {string} to the cart")
    public void add_product_to_cart(String productId) {
        inventoryPage.addProductToCart(productId);
    }

    @And("opens the cart")
    public void open_cart() {
        inventoryPage.openCart();
    }

    // ----- CHECKOUT -----
    @And("proceeds to checkout")
    public void proceed_to_checkout() {
        cartPage.clickCheckout();
    }

    @And("enters first name {string}, last name {string}, postal code {string}")
    public void fill_checkout_information(String firstName, String lastName, String postalCode) {
        checkoutPage.fillInfo(firstName, lastName, postalCode);
    }

    @And("clicks continue")
    public void click_continue() {
        checkoutPage.clickContinue();
    }

    @And("clicks cancel checkout")
    public void click_cancel() {
        checkoutPage.clickCancel();
    }

    // ----- CHECKOUT OVERVIEW -----
    @Then("the overview page should list the added items")
    public void verify_overview_items() {
        List<String> items = overviewPage.getItemNames();
        Assert.assertTrue(items.size() > 0, "Overview should contain at least one item.");
    }

    @And("the total should match the sum of item prices")
    public void verify_total_price() {
        double sum = overviewPage.getItemPrices().stream().mapToDouble(Double::doubleValue).sum();
        double subtotal = overviewPage.getItemTotalFromUI();
        Assert.assertEquals(subtotal, sum, 0.01, "UI subtotal should match sum of prices.");
    }

    @And("finishes checkout")
    public void finish_checkout() {
        overviewPage.clickFinish();
    }

    // ----- CHECKOUT COMPLETE -----
    @Then("the checkout completion page should be displayed")
    public void verify_checkout_complete() {
        String header = completePage.getHeaderText();
        String message = completePage.getMessageText();
        Assert.assertTrue(header.contains("THANK YOU"), "Completion header should confirm order.");
        Assert.assertTrue(message.length() > 0, "Completion message should not be empty.");
    }

    @And("returns to products page")
    public void back_to_products() {
        completePage.backToProducts();
        Assert.assertTrue(inventoryPage.getAllProductNames().size() > 0,
                "User should be back to inventory page.");
    }
}
