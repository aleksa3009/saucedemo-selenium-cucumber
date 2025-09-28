# Final Report – SauceDemo Automation Project

**Project:** Automated Testing of SauceDemo E-Commerce Portal  
**Tester:** Aleksa Aleksić  
**Duration:** 24-09-2025 to 28-09-2025  
**Base URL:** [https://www.saucedemo.com](https://www.saucedemo.com)

---

## 1. Introduction

This report summarizes the comprehensive automation testing efforts on the SauceDemo e-commerce portal. Over five days, functional, negative, and exploratory scenarios were executed across Login, Inventory, Cart, and Checkout modules to validate core functionalities and ensure stability.

The project demonstrates practical automated testing skills with Selenium WebDriver, Cucumber, TestNG, ExtentReports, and GitHub Actions CI/CD integration.

**Modules Tested:** Login, Inventory, Cart, Checkout  
**Artifacts Produced:** Test Suites, Feature Files, Step Definitions, Page Objects, Execution Logs, ExtentReports, Screenshots, Daily Reports, GitHub Actions CI Workflow

---

## 2. Scope & Objectives

**Scope:**

- Functional validation of core e-commerce modules
- Positive and negative test scenarios
- Automated execution with retries and screenshot capture on failure
- CI/CD integration for continuous validation

**Objectives:**

1. Verify end-to-end user flows in Login, Inventory, Cart, and Checkout modules
2. Detect and report issues with UI elements, data handling, and navigation
3. Generate professional test artifacts suitable for junior QA portfolio
4. Implement automated reporting with ExtentReports and screenshots

---

## 3. Test Environment & Tools

**OS:** Ubuntu 22.04 LTS  
**Browsers:** Chrome 140.0.7339.207, Firefox 129.0  
**Java:** JDK 11  
**Maven:** 3.9.11  
**IDE:** IntelliJ IDEA 2025.2.2  
**Automation Tools:** Selenium WebDriver, Cucumber JVM, TestNG  
**Reporting:** ExtentReports, Screenshots on Failure  
**Version Control:** Git & GitHub  
**CI/CD:** GitHub Actions workflow for automated test execution

---

## 4. Folder Structure & Artifacts

```bash
~/SauceDemoAutomation/
├── README.md
├── pom.xml
├── src/
│   ├── main/java/
│   └── test/java/
│       ├── base/
│       ├── pages/
│       ├── tests/
│       ├── stepdefinitions/
│       └── utils/
├── featureFiles/
├── target/
│   ├── screenshots/
│   └── extent-report.html
├── .github/workflows/ci.yml
├── Logs/
└── Reports/
    ├── DailyReports/
    └── FinalReport.md
```

---

## 5. Test Case Coverage & Metrics

| Module      | Test Cases | PASS | FAIL |
| ----------- | ---------- | ---- | ---- |
| SmokeTest   | 1          | 1    | 0    |
| Login       | 6          | 6    | 0    |
| Inventory   | 6          | 6    | 0    |
| Cart        | 7          | 7    | 0    |
| Checkout    | 13         | 13   | 0    |
| **Total**   | 40         | 40   | 0    |

- **Execution Duration:** 5 days
- **Average per Test Case:** ~10 minutes
- **Overall Test Pass Rate:** 100%

---

## 6. Defect Analysis

- **High Severity:** None reported; all core flows passed successfully
- **Medium/Low Severity:** Minor locator adjustments and browser popups handled via driver options
- **Root Causes:** Early iterations included minor locator inconsistencies and popup interruptions, resolved during development

---

## 7. Exploratory & Additional Insights

1. Chrome and Firefox notification/popups required blocking to stabilize automated flows
2. Explicit waits improved synchronization for dynamic page elements
3. RetryAnalyzer ensured transient failures did not block execution
4. ExtentReports provided clear visualization with embedded screenshots
5. CI workflow ensured automated artifact generation for every push/PR

---

## 8. Lessons Learned & Recommendations

1. **Locator Stability:** Maintain consistent and unique locators for UI elements
2. **Cross-Browser Testing:** Expand coverage to Edge, Safari for broader validation
3. **Retry & Reporting:** Continue using retry analyzers and automated reporting for reliable execution
4. **CI/CD Maintenance:** Regularly update workflow to include new test modules
5. **Portfolio Readiness:** Well-documented artifacts and reports showcase professional QA skills

---

## 9. Conclusion

All modules of SauceDemo Automation were tested successfully with 100% pass rate. Reporting, screenshot capture, and CI/CD automation were fully implemented. The project demonstrates strong foundational QA automation skills suitable for a junior tester portfolio.

All test artifacts, reports, and workflow files are ready for review. This completes the automated testing project for SauceDemo E-Commerce Portal.
