package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


//Utility class to read properties from config.properties

public class ConfigUtil {

    private static Properties properties = new Properties(); // Properties object

    static {
        try {
            // Load properties file from resources folder
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis); // load key-value pairs
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file."); // stop execution if fail
        }
    }

    // Get property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key); // return value as String
    }

    public static String getBaseUrl() {
        return getProperty("baseUrl"); // return base URL
    }

    public static String getBrowser() {
        return getProperty("browser"); // return default browser
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicitWait")); // return implicit
    }

    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicitWait")); // return explicit wait
    }
}
