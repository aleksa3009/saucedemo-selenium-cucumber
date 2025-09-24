# Daily Report – 24-09-2025 (Day 1)

---

## Activities:
- Created project repository structure for **SauceDemo Automation** locally and on GitHub.
- Configured **Maven project** with dependencies for Selenium WebDriver, Cucumber, TestNG, ExtentReports, Log4j2.
- Implemented **BaseTest** class with WebDriver setup/teardown.
- Added **DriverFactory** for browser selection (Chrome/Firefox) and properties configuration.
- Created **config.properties** and **log4j2.xml** for environment and logging settings.
- Developed multiple **utility classes**:
    - `ScreenshotUtil.java` for automatic screenshot capture on failures.
    - `ConfigReader.java` for reading config properties.
    - `LoggerUtil.java` for Log4j2 logging integration.
- Implemented **SmokeTest**:
    - Validated home page title "Swag Labs".
    - Verified login flow with fixed user credentials.
    - Added detailed input comments in the test code for readability.
- Added **TestNG suite file** (`testng.xml`) to allow Maven execution of all or specific tests.
- Updated `.gitignore`:
    - Ignored `target/`, logs, IntelliJ-specific files except essential project files.
- Committed all utilities, BaseTest, SmokeTest, TestNG configuration, and `.gitignore` updates with descriptive commit message.
- Verified local Maven build and test execution:
    - `mvn -Dbrowser=chrome clean test` ran successfully with SmokeTest passing.
    - ExtentReports ready for integration in reporting.

---

## Environment:
- **OS:** Linux Ubuntu 22.04 LTS
- **Browsers:** Google Chrome 140.0.7339.207, Firefox 143.0.1
- **Java:** JDK 11
- **Maven:** 3.9.11
- **IDE:** IntelliJ IDEA 2025.2.x
- **Tools/Libraries:** Selenium WebDriver 4.35.0, Cucumber JVM 7.29.x, TestNG 7.11.0, ExtentReports 5.1.2, Log4j2 2.25.x

---

## Issues:
- Minor warning from Maven about deprecated `sun.misc.Unsafe` method; non-blocking.
- Configuration difficulties with JDK 24 setup are insolvable.
- Initial SLF4J warnings resolved after adding Log4j2 configuration.
- Dependencies' versions were not aligned with structures of `BaseTest` and `pom.xml` files.
- No other blockers; SmokeTest stable.

---

## Next Steps (Day 2):
1. **Implement InventoryPage & CartPage POM classes** with locators and actions.
2. **Write feature files** for Inventory and Cart modules and step definitions.
3. **Add negative test cases** for login and inventory functionalities.
4. **Integrate screenshots-on-failure hook** in BaseTest.
5. **Start working on ExtentReports HTML integration** for enhanced test reporting.
6. **Prepare Day 2 Daily Report** documenting progress.
