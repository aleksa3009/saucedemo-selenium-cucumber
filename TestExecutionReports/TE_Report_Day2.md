# Test Execution Report -- Day 2

## Date

25-09-2025

## Test Suites Executed

-   `Login.feature` -- Login and Logout test scenarios for SauceDemo
    E-Commerce site

## Environment

-   Base URL: https://www.saucedemo.com
-   Browser: Chrome 140.0.7339.207 (with notification & popup blocking
    enabled)
-   Viewport: default (Chrome window)
-   Screenshots: captured on test failure
-   Video recording: not configured

## Execution Summary

-   Total tests executed: 6
-   Passed: 6
-   Failed: 0
-   Skipped: 0

## Test Details

### Login.feature

1.  **Successful login with standard user**
    -   Status: Passed
2.  **Successful login with problem user**
    -   Status: Passed
3.  **Unsuccessful login with empty username**
    -   Status: Passed
4.  **Unsuccessful login with empty password**
    -   Status: Passed
5.  **Unsuccessful login with wrong password**
    -   Status: Passed
6.  **Logout after successful login**
    -   Status: Passed

## Issues Encountered

-   Chrome browser popups and notifications caused test instability
    until DriverFactory was updated with proper blocking options.
-   Some locators (ID and class selectors) were unreliable; need to
    refine them for better stability.

## Artifacts

-   Screenshots folder will contain captures if any failures occur.
-   ExtentReports HTML report generated at `reports/extent-report.html`.

## Next Steps

-   Implement remaining Page Object Model (POM) classes for Inventory,
    Cart, and Checkout modules.
-   Add more Selenium and Cucumber test scenarios to expand coverage.
-   Plan CI/CD integration with GitHub Actions for automated runs.