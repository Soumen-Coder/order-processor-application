package com.soumen.dataProcessor;

import com.soumen.dataReader.DataReader;
import com.soumen.dataReader.MockCSVReader;
import com.soumen.model.Order;
import com.soumen.orderPersister.MockOrderDataSplitter;
import com.soumen.orderPersister.OrderDataPersister;
import com.soumen.orderPersister.OrderPersister;
import com.soumen.orderSplitter.MockOrderDataPersister;
import com.soumen.orderSplitter.OrderDataSplitter;
import com.soumen.orderSplitter.OrderSplitter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
/**
* This class is responsible for testing the process data order functionality
 */
public class OrderDataProcessorTest {

    // Test case for the processOrders method
    @Test
    public void testProcessDataOrders() {
        // Create necessary test data, mocks, and expectations
        List<Order> orders = createTestOrders();


        // Create a mock MockOrderDataPersister instance
        MockOrderDataPersister orderPersister = new MockOrderDataPersister();

        //Create a MockCSVReader instance
        DataReader dataReader = new MockCSVReader();

        //Create a MockOrderDataSplitter
        OrderSplitter orderSplitter = new MockOrderDataSplitter();

        // Create an instance of OrderDataProcessorImpl
        DataProcessor dataProcessor = OrderDataProcessorImpl.create(dataReader, orderSplitter, orderPersister);

        // Invoke the method being tested
        dataProcessor.processDataOrders();

        // Verify that the OrderPersister's persistOrders method was called with the correct orders
        assertTrue(orderPersister.isPersistOrdersCalled());
        assertEquals(orders, orderPersister.getPersistedOrders());

    }

    @Test
    public void testSplitDataOrdersByCountry() {
        // Test case for the splitOrdersByCountry method

        // Create a mock MockOrderDataPersister instance
        MockOrderDataPersister orderPersister = new MockOrderDataPersister();

        //Create a MockCSVReader instance
        DataReader dataReader = new MockCSVReader();

        //Create a MockOrderDataSplitter
        OrderSplitter orderSplitter = new MockOrderDataSplitter();

        // Create an instance of OrderDataProcessorImpl
        DataProcessor dataProcessor = OrderDataProcessorImpl.create(dataReader, orderSplitter, orderPersister);

        // Invoke the method being tested
        Map<String, List<Order>> ordersByCountryMap = dataProcessor.splitDataOrdersByCountry(createTestOrders());

        // Verify that the orders were correctly split by country
        assertEquals(2, ordersByCountryMap.size());

        // Verify the number of orders for each country via ordersByCountryMap
        for (Map.Entry<String, List<Order>> OrderMap : ordersByCountryMap.entrySet()) {
            if (OrderMap.getKey().equals("Cameroon")) {
                assertEquals(2, OrderMap.getValue().size());
            } else if (OrderMap.getKey().equals("Morocco")) {
                assertEquals(1, OrderMap.getValue().size());
            }
        }

    }

    // Helper method to create test orders
    private List<Order> createTestOrders() {
        Order order1 = new Order();
        order1.setOrderId(String.valueOf(1));
        order1.setEmailId("email1@email.com");
        order1.setPhoneNumber("237 209993809");
        order1.setParcelWeight(24.45);

        Order order2 = new Order();
        order2.setOrderId(String.valueOf(2));
        order2.setEmailId("email2@email.com");
        order2.setPhoneNumber("258 852828436");
        order2.setParcelWeight(1.33);

        return new ArrayList<>(Arrays.asList(order1, order2));
    }


}