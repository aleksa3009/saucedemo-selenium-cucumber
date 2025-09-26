package stepdefinitions;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.Assert;

public class CartSteps {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @Given("the user is logged in and on the cart page")
    public void the_user_is_logged_in_and_on_the_cart_page() {
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();

        // 1. Otvori login stranicu i uloguj se
        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");

        // 2. Dodaj Backpack u korpu
        inventoryPage.addProductToCart("add-to-cart-sauce-labs-backpack");

        // 3. Otvori cart page
        inventoryPage.openCart();
    }

    @Then("the user should see {int} items in the cart")
    public void the_user_should_see_items_in_the_cart(Integer count) {
        int actualCount = cartPage.getCartItemNames().size();
        Assert.assertEquals(actualCount, count.intValue());
    }

    @When("the user removes {string} from the cart")
    public void the_user_removes_from_the_cart(String productName) {
        cartPage.removeItemByName(productName);
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @When("the user clicks continue shopping")
    public void the_user_clicks_continue_shopping() {
        cartPage.clickContinueShopping();
    }

    @Then("the user should be on the inventory page")
    public void the_user_should_be_on_the_inventory_page() {
        Assert.assertTrue(loginPage.isAtInventoryPage());
    }

    @When("the user clicks checkout")
    public void the_user_clicks_checkout() {
        cartPage.clickCheckout();
    }
}
