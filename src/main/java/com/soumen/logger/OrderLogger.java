package com.soumen.logger;

public class OrderLogger {
    private static final OrderLogger instance = new OrderLogger();

    // private access specifier to prevent instantiation
    private OrderLogger() {

    }

    // get an instance of the logger
    public static OrderLogger getInstance() {
        return instance;
    }

    //log messages
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }

    // log error messages
    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
