package com.soumen.dataReader;

import com.soumen.model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * This class is responsible for mocking a csv reader.
 */
public class MockCSVReader implements DataReader {
    private boolean readDataCalled;

    @Override
    public List<Order> readDataOrders() {
        this.readDataCalled = true;
        return createTestOrders();
    }

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

        // Create and add test orders to the list

        return new ArrayList<>(Arrays.asList(order1, order2));
    }

    public boolean isReadDataCalled() {
        return readDataCalled;
    }
}