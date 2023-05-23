package com.soumen.orderParser;

import com.soumen.model.Order;

/**
 * Defines contract for parsing data from a data source.
 * Implementations class should provide methods to parse the orders.
 */
public interface OrderParser {
    //This method is responsible for parsing data orders.
    Order parseOrder(String line);
}
