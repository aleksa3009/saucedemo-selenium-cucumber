# Daily Report – 27-09-2025 (Day 4)

---

## Activities:
- Implemented **Checkout.feature** with basic Cucumber scenarios:
    - Successful checkout flow (login → add product → checkout info → overview → complete).
    - Negative cases for missing fields (first name, last name, postal code).
    - Cancel checkout navigation back to cart.
- Developed **CheckoutSteps.java** step definitions:
    - Aligned Gherkin steps with page object methods.
    - Added logging and error handling for visibility.
- Added **CheckoutOverviewTests.java**:
    - Verified product names, prices, and subtotal calculation on the overview page.
- Added **CheckoutCompleteTests.java**:
    - Verified success header/message on completion page.
    - Verified navigation back to inventory via "Back to Products".
- Ran full regression on Login, Cart, Inventory, and Checkout modules – all tests passed.
- Confirmed ExtentReports generation for execution results.

---

## Environment:
- **OS:** Linux Ubuntu 22.04 LTS
- **Browsers:** Google Chrome 140.0.7339.207, Firefox 129.0
- **Java:** JDK 11
- **Maven:** 3.9.11
- **IDE:** IntelliJ IDEA 2025.2.2

---

## Issues:
- Minor locator instability on overview page fixed by switching to CSS selectors.
- Step definitions required strict alignment with Gherkin phrasing to avoid mismatch.
- Needed adjustment of `waitForVisibility` usage within page objects for consistency.

---

## Next Steps (Day 5):
- Create **DailyReport.md** and **Test Execution Report (TER)** automation for reporting pipeline.
- Expand Checkout scenarios with additional edge cases (multiple products, invalid postal code formats).
- Final refactoring of Cucumber feature files for consistency across modules.
- Prepare final **consolidated regression run** and documentation.  
