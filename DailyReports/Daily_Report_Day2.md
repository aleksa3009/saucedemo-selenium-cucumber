# Daily Report – 25-09-2025 (Day 2)

---

## Activities:
- Executed **Login.feature** with multiple scenarios:
    - Successful login with standard user.
    - Successful login with problem user.
    - Unsuccessful login with empty username.
    - Unsuccessful login with empty password.
    - Unsuccessful login with wrong password.
    - Logout after successful login.
- Implemented and verified **step definitions** in `LoginSteps.java`.
- Updated **DriverFactory.java** to block Chrome notifications, pop-ups, and infobars.
- Verified execution on both Chrome and Firefox browsers.
- All tests passed successfully after environment fixes.
- Improved stability by aligning browser options with test requirements.

---

## Environment:
- **OS:** Linux Ubuntu 22.04 LTS
- **Browsers:** Google Chrome 140.0.7339.207, Firefox 143.0.1
- **Java:** JDK 11
- **Maven:** 3.9.11
- **IDE:** IntelliJ IDEA 2025.2.x


---

## Issues:
- Chrome tests initially failed due to **notifications and pop-up windows** interfering with login flow.
- Several **locators could not be found** by `id` or `class` selectors; alternative strategies (XPath, CSS) were applied.
- Firefox execution stable, no major blocking issues observed.

---

## Next Steps (Day 3):
- Implement `InventoryPage` and `CartPage` with full POM structure.
- Write feature files for **Inventory** and **Cart** modules.
- Add step definitions for Inventory & Cart scenarios.
- Stabilize tests locally and fix flaky locators.

---