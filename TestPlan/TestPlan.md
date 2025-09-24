# Test Plan – SauceDemo E​-Commerce QA Automation

**Author:** Aleksa Aleksić  
**Date:** September 24, 2025  
**Project:** SauceDemo E​-Commerce QA Automation  
**Base URL:** https://www.saucedemo.com

---

## 1. Introduction
This test plan defines the strategy for automating UI functional tests for the SauceDemo e-commerce site. The test suite is designed to validate critical business workflows such as login, inventory navigation, cart operations, and order checkout.

Automation is implemented using Java with:
- **Selenium WebDriver** for browser interaction
- **Cucumber BDD** for test readability and business alignment
- **Page Object Model (POM)** for maintainable and reusable components
- **TestNG** for execution control and suite management
- **ExtentReports** for visually interactive HTML reports

Test cases are written in Gherkin syntax and mapped to POM-driven step definitions. Tests are integrated into GitHub Actions CI/CD pipelines to ensure regression detection with every commit.

---

## 2. Scope
**In Scope:**
- Authentication: valid login, locked-out/problem/performance glitch users, error handling
- Inventory Page: product card visibility, sorting, product details
- Shopping Cart: add/remove items, verify cart icon, content validation
- Checkout Process: form validation, overview validation, order completion
- Data Combinations: multiple users, sorting options

**Out of Scope:**
- Backend/API validation
- Mobile/responsive testing
- Performance/load testing
- Accessibility (WCAG)

---

## 3. Objectives
- Ensure all critical user flows work across major browsers
- Detect UI regressions early via CI integration
- Maintain clean, reusable code with POM + Cucumber
- Provide report-backed evidence for QA activities

---

## 4. Roles & Responsibilities
| Role        | Name           | Responsibility                                                        |
|-------------|----------------|-----------------------------------------------------------------------|
| QA Engineer | Aleksa Aleksić | Develop page classes, write tests, configure TestNG & CI, generate reports and daily reports |
| Reviewer    | Peer QA Lead   | Validate features, step logic, test data, automation integrity        |
| Stakeholder | Product Owner  | Approve test cases, prioritize defects, confirm coverage             |

---

## 5. Test Items
| Module                | Key Scenarios                                          | Positive Tests                    | Negative Tests                       |
|-----------------------|--------------------------------------------------------|----------------------------------|-------------------------------------|
| Login Page            | Login/logout with different users                      | Valid login, logout              | Empty fields, locked user, wrong password |
| Inventory Page        | Sorting, navigation, item details                      | Correct sort, visible items      | Incorrect sort, missing images      |
| Cart Page             | Add/remove items, cart counter                         | Items reflect in cart            | Remove non-existing items           |
| Checkout: Info        | Form validation                                        | Valid input proceeds             | Missing fields trigger error        |
| Checkout: Overview    | Total price, item names                                 | Matches subtotal, tax, total     | Mismatched items, buttons not working |
| Checkout: Complete    | Thank you message, back to home                         | Confirmation displayed            | Order fails, message missing        |

---

## 6. Test Strategy & Approach
1. **Framework Structure:** BaseTest, Page Objects, Step Definitions, Hooks, Utilities
2. **BDD Layer (Cucumber):** `.feature` files in `src/test/resources/features`, tags `@smoke`, `@checkout`, `@regression`, `@negative`
3. **Execution Layer (TestNG):** Runner configured via `testng.xml`, parallel execution optional
4. **Synchronization:** `WebDriverWait`, RetryAnalyzer for flaky tests
5. **Error Handling & Logs:** Try-catch, screenshots on failure, Log4j2 logging
6. **Reporting:** ExtentReports HTML dashboard
7. **CI/CD:** GitHub Actions workflow: trigger on push/PR, archive reports/screenshots, upload failed screenshots

---

## 7. Environment & Tools
- **OS:** Ubuntu 22.04 LTS
- **Browsers:**
    - Chrome 4.35.0 driver (Selenium-managed)
- **Java Version:** JDK 11
- **Build Tool:** Maven 3.9.11
- **Test Libraries / Frameworks:**
    - Selenium WebDriver 4.35.0
    - Cucumber JVM 7.29.x
    - TestNG 7.11.0
- **Reports & Logs:**
    - ExtentReports 5.1.2
    - Log4j2 2.25.0
- **IDE:** IntelliJ IDEA 2025.2.2
- **CI/CD:** GitHub Actions workflow (`mvn test`, archive `/reports/` and `/screenshots/`)

---

## 8. Entry & Exit Criteria
**Entry Criteria:**
- Project cloned, Maven dependencies resolved
- `config.properties` and `log4j2.xml` configured
- Initial page classes and stepdefs implemented
- Feature files structured by module

**Exit Criteria:**
- All `@smoke` and `@regression` scenarios passing
- Reports generated in `/reports/extent-report.html`
- Logs generated in `/logs/test.log`
- Daily reports created documenting progress (`docs/Daily_Report_YYYY-MM-DD.md`)
- TestPlan.md and test execution reports maintained
- All critical defects logged and tagged in GitHub Issues

---

## 9. Risks & Mitigation
| Risk                        | Likelihood | Impact | Mitigation                                   |
|------------------------------|-----------|--------|----------------------------------------------|
| Dynamic elements breaking    | Medium    | High   | Use resilient locators, retries, waits      |
| Flaky tests from slow loads  | High      | Medium | Implement WebDriverWait, avoid Thread.sleep |
| Locked/unstable demo users   | Medium    | Medium | Rotate user profiles per run                |
| CI environment differences   | Low       | High   | Ensure consistent setup or Docker environment |

---

## 10. Deliverables
- **Test Plan Document:** `docs/SauceDemo_TestPlan.md`
- **Feature Files:** `src/test/resources/features/*.feature`
- **Page Classes:** `src/main/java/pages/*.java`
- **Step Definitions:** `src/test/java/stepdefs/*.java`
- **Test Runner:** `src/test/java/runners/TestRunner.java`
- **Reports:** `reports/extent-report.html`
- **Logs:** `logs/test.log`
- **Daily Reports:** `docs/Daily_Report_YYYY-MM-DD.md`
- **Test Execution Reports:** HTML/JSON (from ExtentReports or surefire)
- **CI Results:** GitHub Actions -> Artifacts, Badges
- **Final Summary Report:** `docs/Final_Test_Summary.md`

---

## 11. Schedule
| Day | Task Description                                                   | Time Estimate |
|-----|--------------------------------------------------------------------|---------------|
| 1   | Environment setup, Maven, DriverFactory, config reader, project skeleton, quick smoke run | 7h |
| 2   | BaseTest, Hooks, logger, basic POM, `LoginPage` + `Login.feature` | 8h |
| 3   | `InventoryPage` + `CartPage`, Inventory & Cart features/stepdefs, stabilize locally | 8h |
| 4   | Checkout pages (`CheckoutInfo`, `Overview`, `Complete`), write checkout features, validate totals | 8h |
| 5   | Add negative/boundary scenarios, RetryAnalyzer, screenshot-on-failure hook, integrate ExtentReports | 8h |
| 6   | GitHub Actions workflow, full suite CI run, archive reports/screenshots, finalize README/docs | 8h |