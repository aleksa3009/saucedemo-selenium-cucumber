package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Simple Logger Utility using Log4j2

public class LoggerUtil {

    // Create logger instance
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    // Log info message
    public static void info(String message) {
        logger.info(message);
    }

    // Log warning message
    public static void warn(String message) {
        logger.warn(message);
    }

    // Log error message
    public static void error(String message) {
        logger.error(message);
    }
}
