package com.soumen.dataProcessor;

import com.soumen.dataReader.DataReader;
import com.soumen.logger.OrderLogger;
import com.soumen.model.Order;
import com.soumen.orderPersister.OrderDataPersister;
import com.soumen.orderSplitter.OrderDataSplitter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class OrderDataProcessorImpl implements DataProcessor{

    private final DataReader dataReader;
    private final OrderDataSplitter orderDataSplitter;
    private final OrderDataPersister orderDataPersister;
    private final OrderLogger logger;

    public OrderDataProcessorImpl(DataReader dataReader, OrderDataSplitter orderDataSplitter, OrderDataPersister orderDataPersister, OrderLogger logger) {
        this.dataReader = dataReader;
        this.orderDataSplitter = orderDataSplitter;
        this.orderDataPersister = orderDataPersister;
        this.logger = logger;
    }

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

    @Override
    public Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders) {
        return orderDataSplitter.splitDataOrdersByCountry(orders);
    }

}
