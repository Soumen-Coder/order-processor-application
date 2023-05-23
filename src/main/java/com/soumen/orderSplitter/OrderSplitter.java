package com.soumen.orderSplitter;

import com.soumen.model.Order;

import java.util.List;
import java.util.Map;

/**
 * Defines contract for splitting data from a data source.
 * Implementations class should provide methods to split the orders based on the country name.
 */
public interface OrderSplitter {
    //This method splits the data based on the country
    Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders);
}
