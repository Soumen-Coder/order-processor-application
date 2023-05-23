package com.soumen.logger;

/**
 * Provides logging functionality for the application using the singleton design patterns.
 * Implements the Singleton design pattern to ensure a single instance of the logger is being used.
 * Provides methods to log messages.
 */
public class OrderLoggerFactory {
    private static final OrderLogger ORDER_LOGGER_INSTANCE = new OrderLogger();

    private OrderLoggerFactory() {
        // prevent instantiation as the constructor is made private
    }

    public static OrderLogger getLogger() {
        return ORDER_LOGGER_INSTANCE;
    }
}
