# Daily Report – 26-09-2025 (Day 3)

---

## Activities:
- Implemented **InventoryTests.java** covering:
    - Inventory page displays all products.
    - Adding multiple products to the cart.
    - Product button text changes to 'Remove' after adding to cart.
    - Product details navigation works correctly.
- Added and verified **CartTests.java** with essential scenarios:
    - Adding a single product to the cart.
    - Removing products from the cart.
    - Verifying cart badge updates correctly.
- Confirmed **LoginTests.java** execution with standard user flow.
- Conducted full execution run to validate `BaseTest`, `LoginPage`, `InventoryPage`, and `CartPage`.
- Organized tests into `tests` package with structured POM usage.
- All implemented tests passed successfully in stable environment.

---

## Environment:
- **OS:** Linux Ubuntu 22.04 LTS
- **Browsers:** Google Chrome 140.0.7339.207, Firefox 143.0.1
- **Java:** JDK 11
- **Maven:** 3.9.11
- **IDE:** IntelliJ IDEA 2025.2.2

---

## Issues:
- Intermittent **password popup** interfered with login during early runs; once suppressed, all flows passed smoothly.
- Some product locators required adjustments (migrated from `id` to CSS selectors for consistency).
- Cart badge occasionally updated with delay; mitigated with explicit waits in helper methods.

---

## Next Steps (Day 4):
- Expand **Cart tests** with checkout flow scenarios (CheckoutPage implementation).
- Add feature files and Cucumber step definitions for Inventory and Cart modules.
- Integrate logging improvements for clearer reporting during failures.
- Prepare consolidated **Test Execution Report (TER)** with screenshots of failures (if any).