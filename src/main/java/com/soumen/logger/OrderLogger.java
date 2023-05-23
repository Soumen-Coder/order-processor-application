package com.soumen.logger;

/**
 * This class is responsible for logging messages
 * Provides methods to log messages.
 */
public class OrderLogger {
    //log messages
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }

    // log error messages
    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
