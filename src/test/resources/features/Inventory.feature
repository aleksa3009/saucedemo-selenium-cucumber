Feature: Inventory page functionality
  Verify inventory page products, prices, buttons, and layout

  Background:
    Given the user is logged in as "standard_user"
    And the user is on the inventory page

  @smoke
  Scenario: Verify total number of products
    Then the number of products displayed should be 6

  Scenario: Verify all product names
    Then the product names should exactly be:
      | Sauce Labs Backpack |
      | Sauce Labs Bike Light |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario: Verify all product prices
    Then the product prices should exactly be:
      | $29.99 |
      | $9.99 |
      | $15.99 |
      | $49.99 |
      | $7.99 |
      | $15.99 |
