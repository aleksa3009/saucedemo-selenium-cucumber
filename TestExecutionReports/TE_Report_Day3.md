# Test Execution Report -- Day 3

## Date
26-09-2025

## Test Suites Executed
- `Cart.feature` – Cart functionality scenarios (add, remove, continue shopping, checkout navigation)
- `Inventory.feature` – Inventory page product listing, names, prices, buttons
- `LoginTests`, `CartTests`, `InventoryTests` (TestNG, Selenium)

## Environment
- Base URL: https://www.saucedemo.com
- Browsers:
    - Chrome 140.0.7339.207 (with notification & popup blocking enabled)
    - Firefox 129.0 (popups disabled via driver options)
- Viewport: default (maximized window)
- Screenshots: captured on failure
- Reports: ExtentReports HTML report generated at `reports/extent-report.html`

## Execution Summary
- **Total tests executed:** 20
- **Passed:** 20
- **Failed:** 0
- **Skipped:** 0

## Test Details

### Cart.feature / CartTests
1. **Verify single item in cart** – Passed
2. **Remove item from cart** – Passed
3. **Continue shopping from cart** – Passed
4. **Checkout from cart (navigation only)** – Passed
5. **Add product to cart (TestNG)** – Passed
6. **Remove product from cart (TestNG)** – Passed
7. **Continue shopping button returns to inventory page (TestNG)** – Passed

### Inventory.feature / InventoryTests
1. **Verify total number of products = 6** – Passed
2. **Verify all product names** – Passed
3. **Verify all product prices** – Passed
4. **Inventory page displays products (TestNG)** – Passed
5. **Add multiple products to cart (TestNG)** – Passed
6. **Product button text changes to ‘Remove’ after add (TestNG)** – Passed

### LoginTests (re-executed for stability check)
- Valid login, logout, invalid login, and empty field scenarios – All Passed

## Issues Encountered
- **Browser popups and notifications**: caused instability until ChromeOptions/FirefoxOptions were updated with proper blocking preferences.
- **Locators**: some initial ID/class selectors were unreliable; refined them to improve stability.
- **Cucumber step definitions**: Gherkin step wording (Given/When/Then) must exactly match Java method signatures – need to align wording consistently.

## Artifacts
- Screenshots (available for debugging on failures).
- HTML report generated via ExtentReports at `reports/extent-report.html`.

## Next Steps
- Implement **Checkout tests**: Information, Overview, and Complete pages.
- Expand negative test scenarios (e.g., checkout without items).
- Refactor Gherkin steps to ensure consistent mapping with step definition methods.  