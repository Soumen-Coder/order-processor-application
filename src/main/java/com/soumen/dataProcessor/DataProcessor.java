package com.soumen.dataProcessor;

import com.soumen.model.Order;

import java.util.List;
import java.util.Map;

public interface DataProcessor {
    void processDataOrders();
    Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders);
}
