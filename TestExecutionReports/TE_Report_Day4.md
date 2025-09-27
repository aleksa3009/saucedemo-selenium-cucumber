# Test Execution Report -- Day 4

## Date
27-09-2025

## Test Suites Executed
- `Checkout.feature` – Checkout flow scenarios (login, add to cart, checkout information, overview, complete)
- `CheckoutTests` – Selenium/TestNG tests for CheckoutInfoPage, CheckoutOverviewPage, CheckoutCompletePage

## Environment
- Base URL: https://www.saucedemo.com
- Browsers:
    - Chrome 140.0.7339.207 (notifications & popups blocked)
    - Firefox 129.0 (popups disabled via driver options)
- Viewport: default (maximized window)
- Screenshots: captured on failure
- Reports: ExtentReports HTML report generated at `reports/extent-report.html`

## Execution Summary
- **Total tests executed:** 13
- **Passed:** 13
- **Failed:** 0
- **Skipped:** 0

## Test Details

### Checkout.feature / CheckoutSteps
1. **Successful checkout (login → add to cart → info → overview → finish)** – Passed
2. **Checkout without first name** – Passed
3. **Checkout without last name** – Passed
4. **Checkout without postal code** – Passed
5. **Cancel checkout returns to cart** – Passed
6. **Checkout with whitespace-only fields** – Passed
7. **Complete checkout step two and finish** – Passed

### CheckoutTests (Selenium / TestNG)
1. **Verify item names and prices on overview page** – Passed
2. **Verify item total matches sum of prices** – Passed
3. **CheckoutOverviewPage displays correct items** – Passed
4. **CheckoutOverviewPage calculates subtotal correctly** – Passed
5. **CheckoutCompletePage displays header and message** – Passed
6. **Back to products button navigates correctly** – Passed

## Issues Encountered
- **waitForVisibility** in BasePage is protected – required careful usage in tests; no impact after adjusting page object methods.
- Minor locator adjustments for stability in overview and complete pages.
- Cucumber step definitions had to be aligned with `Checkout.feature` wording.

## Next Steps
- Start implementing **Cucumber Steps for daily reporting and other remaining features**.
- Extend negative checkout scenarios (multiple items, invalid postal codes).
- Integrate **daily report generation** automatically after test execution.  
