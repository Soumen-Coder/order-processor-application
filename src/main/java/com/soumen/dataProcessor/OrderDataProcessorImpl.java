package com.soumen.dataProcessor;

import com.soumen.dataReader.DataReader;
import com.soumen.logger.OrderLogger;
import com.soumen.logger.OrderLoggerFactory;
import com.soumen.model.Order;
import com.soumen.orderPersister.OrderDataPersister;
import com.soumen.orderPersister.OrderPersister;
import com.soumen.orderSplitter.OrderDataSplitter;
import com.soumen.orderSplitter.OrderSplitter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * Processes orders by splitting them based on country and persisting the orders.
 * Implements the DataProcessor Interface for handling order processing operations.
 */
public class OrderDataProcessorImpl implements DataProcessor{

    private final DataReader dataReader;
    private final OrderSplitter orderDataSplitter;
    private final OrderPersister orderDataPersister;
    private final OrderLogger logger;

    public OrderDataProcessorImpl(DataReader dataReader, OrderSplitter orderDataSplitter, OrderPersister orderDataPersister, OrderLogger logger) {
        this.dataReader = dataReader;
        this.orderDataSplitter = orderDataSplitter;
        this.orderDataPersister = orderDataPersister;
        this.logger = logger;
    }

    public static OrderDataProcessorImpl create(DataReader dataReader, OrderSplitter orderDataSplitter, OrderPersister orderDataPersister) {
        OrderLogger logger = OrderLoggerFactory.getLogger(); // Obtain the logger from a factory
        return new OrderDataProcessorImpl(dataReader, orderDataSplitter, orderDataPersister, logger);
    }

    //Method to process orders and persist them
    @Override
    public void processDataOrders() {
        //Read the order from the csv file
        List<Order> orders = dataReader.readDataOrders();

        //Processing logic starts here
        Map<String, List<Order>> ordersByCountryMap = orderDataSplitter.splitDataOrdersByCountry(orders);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> ordersByCountryMap.forEach((country, orderList) -> {
            logger.log("Processing orders for " + country);

            // Perform any processing logic here

            logger.log("Order processed for the country "+ country);

        }));

        //persists the orders in a database
        orderDataPersister.persistDataOrders(ordersByCountryMap);
    }

    /**
     * Splits orders by country.
     * @return Map<String, List<Order>>
     */
    @Override
    public Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders) {
        return orderDataSplitter.splitDataOrdersByCountry(orders);
    }

}
