Feature: Checkout flow on SauceDemo

  As a standard user
  I want to complete the checkout process
  So that I can purchase items successfully

  Scenario: Successful checkout
    Given the user is logged in as "standard_user"
    When the user adds "add-to-cart-sauce-labs-backpack" to the cart
    And opens the cart
    And proceeds to checkout
    And enters first name "Aleksa", last name "Aleksic", postal code "21000"
    And clicks continue
    Then the overview page should list the added items
    And the total should match the sum of item prices
    And finishes checkout
    Then the checkout completion page should be displayed
    And returns to products page

  Scenario: Checkout with missing first name
    Given the user is logged in as "standard_user"
    When the user adds "add-to-cart-sauce-labs-backpack" to the cart
    And opens the cart
    And proceeds to checkout
    And enters first name "", last name "Aleksic", postal code "21000"
    And clicks continue
    Then the overview page should list the added items
