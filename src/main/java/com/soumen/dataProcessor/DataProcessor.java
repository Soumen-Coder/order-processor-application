package com.soumen.dataProcessor;

import com.soumen.model.Order;

import java.util.List;
import java.util.Map;

/**
 * Defines contract for processing data from a data source.
 * Implementations class should provide methods to process orders.
 */
public interface DataProcessor {
   //This method process data from a data source
    void processDataOrders();

    /**
     * splits order by country.
     * @return Map<String,List<Order>>
     */
    Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders);
}
