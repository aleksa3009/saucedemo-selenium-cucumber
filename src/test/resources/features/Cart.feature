Feature: Cart functionality
  As a user
  I want to manage items in the cart
  So that I can continue shopping, remove items or checkout

  Scenario: Verify single item in cart
    Given the user is logged in and on the cart page
    Then the user should see 1 items in the cart

  Scenario: Remove item from cart
    Given the user is logged in and on the cart page
    When the user removes "Sauce Labs Backpack" from the cart
    Then the cart should be empty

  Scenario: Continue shopping from cart
    Given the user is logged in and on the cart page
    When the user clicks continue shopping
    Then the user should be on the inventory page

  Scenario: Checkout from cart
    Given the user is logged in and on the cart page
    When the user clicks checkout
