# SauceDemo – Selenium Cucumber Automation Testing Project

A comprehensive automation QA project showcasing end-to-end UI testing of the SauceDemo e-commerce demo site ([https://www.saucedemo.com](https://www.saucedemo.com)) using **Selenium WebDriver, Cucumber BDD, TestNG, ExtentReports, and GitHub Actions CI/CD**.

---

## Project Overview

This repository contains all artifacts produced during a five-day automation testing engagement on SauceDemo, covering:

- **Login:** Positive and negative authentication scenarios
- **Inventory:** Product listing, details, and add/remove from cart
- **Cart:** Item validation, badge updates, remove functionality
- **Checkout:** Information form, overview validation, and order completion
- **Smoke Suite:** Title validation, login flow stability

A total of **40 structured test cases and 6 feature files** were automated and executed, including regression and negative scenarios.

**Note:** All tests are passing as of **28-09-2025**. Since SauceDemo is a public demo site, **locators or flows may change** over time, which can affect test execution results.

---

## Repository Structure

```bash
~/saucedemo-selenium-cucumber/
├── .idea/
├── .mvn/
├── DailyReports/
├── GitHub/
│   └── workflows/
├── logs/
├── screenshots/
├── src/
│   ├── main/java/pages/
│   ├── main/java/runners/
│   ├── main/java/utils/
│   └── test/java/
│       ├── base/
│       ├── hooks/
│       ├── smoke/
│       ├── stepdefinitions/
│       ├── tests/
│       └── utils/
│   └── test/resources/features/
├── target/
│   ├── screenshots/
│   └── extent-report.html
├── TestExecutionReports/
├── TestPlan/
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

---

## Tools & Environment

- **Operating System:** Ubuntu 22.04 LTS
- **Browsers:** Chrome 140.0.7339.207, Firefox 129.0
- **Programming Language:** Java 11
- **Frameworks & Libraries:** Selenium WebDriver, Cucumber JVM, TestNG, ExtentReports
- **Build Tool:** Maven 3.9.11
- **IDE:** IntelliJ IDEA 2025.2.2
- **CI/CD:** GitHub Actions workflow for build & test execution
- **Version Control:** Git & GitHub

---

## Prerequisites

1. Install **Java JDK 11** and configure `JAVA_HOME`.
2. Install **Maven 3.9.11**.
3. Ensure **ChromeDriver** and **GeckoDriver** are available in PATH.
4. Recommended IDE: **IntelliJ IDEA 2025.2.2** with Maven integration.

---

## Test Planning & Execution Flow

| Day    | Activities                                                                                             |
|--------|--------------------------------------------------------------------------------------------------------|
| Day 1  | Setup repo; configure Maven & dependencies; implement BaseTest, DriverFactory, SmokeTest               |
| Day 2  | Create Login.feature & step defs; implement multiple positive/negative login scenarios                  |
| Day 3  | Develop Inventory & Cart tests; validate add/remove flows and cart badge                                |
| Day 4  | Implement Checkout feature & step defs; complete end-to-end checkout flow                               |
| Day 5  | Add RetryAnalyzer; integrate ExtentReports & screenshots; configure GitHub Actions CI; finalize docs    |

All detailed progress notes are under **DailyReports/**.  
Full execution logs are located in **TestExecutionReports/**.

---

## Test Coverage & Metrics

| Module      | Test Cases | PASS | FAIL |
| ----------- | ---------- | ---- | ---- |
| SmokeTest   | 1          | 1    | 0    |
| Login       | 6          | 6    | 0    |
| Inventory   | 6          | 6    | 0    |
| Cart        | 7          | 7    | 0    |
| Checkout    | 13         | 13   | 0    |
| **Total**   | 40         | 40   | 0    |

- **Feature Files:** 6
- **Step Definitions:** Full coverage per feature
- **Average Duration per Test Case:** ~10 minutes
- **Overall Test Pass Rate:** 100%

---

## Notable Implementations

- **Retry Mechanism:** Custom RetryAnalyzer and RetryTransformer for flaky test handling
- **Screenshot Utility:** Automatic capture on test failure, attached in ExtentReports and CI artifacts
- **Reporting:** ExtentReports HTML with step logs, statuses, and screenshots
- **CI/CD Integration:** GitHub Actions workflow for Maven test execution on Ubuntu with Chrome
- **Logging:** Log4j2 integrated for structured runtime logs

---

## Recommendations

1. **Locator Resilience:** Regularly review CSS selectors/XPath as SauceDemo UI can change
2. **Data-Driven Tests:** Expand with external CSV/JSON for broader coverage
3. **Parallel Execution:** Enhance testng.xml for cross-browser parallel runs
4. **Scalability:** Integrate with cloud testing platforms (e.g., BrowserStack/SauceLabs) for wider browser coverage
5. **CI/CD Maintenance:** Keep workflow updated as tests/modules are added

---

## Notes

- Tests are passing as of **28-09-2025**.
- Since SauceDemo is a public demo site, **locators or flows may change**, which can impact test results.
- Artifacts can be reused and updated as the site evolves.

---

## Conclusion

This project demonstrates a robust automation testing framework using Selenium, Cucumber BDD, TestNG, ExtentReports, and CI/CD. With 40 automated tests across Login, Inventory, Cart, and Checkout, detailed reporting, screenshot capture, and workflow automation, this repository is a strong showcase of junior QA automation skills.

All test artifacts, reports, and CI/CD workflow files are included for portfolio and review.