package com.soumen.dataReader;

import com.soumen.model.Order;

import java.util.List;

/**
 * Defines contract for reading data from a data source.
 * Implementations class should provide methods to read orders.
 */
public interface DataReader {
    /**
     * Reads orders from a data source.
     * @return list of Order objects representing the read orders.
     */
    List<Order> readDataOrders();
}
