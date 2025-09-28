package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.concurrent.ConcurrentHashMap;

public class ExtentTestManager {

    private static ExtentReports extent = ExtentManager.getExtentReports();
    private static ConcurrentHashMap<Long, ExtentTest> extentTestMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, String> screenshotMap = new ConcurrentHashMap<>();

    // Start a test for the current thread
    public static synchronized ExtentTest startTest(String name, String description) {
        ExtentTest test = extent.createTest(name, description);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }

    // Get current thread's test
    public static ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    // End current test and flush report
    public static void endTest() {
        extent.flush();
    }

    // Store screenshot path for current thread
    public static void addScreenShotPath(String path) {
        screenshotMap.put(Thread.currentThread().getId(), path);
    }

    // Retrieve and remove screenshot path
    public static String getAndRemoveScreenShotPath() {
        return screenshotMap.remove(Thread.currentThread().getId());
    }
}
