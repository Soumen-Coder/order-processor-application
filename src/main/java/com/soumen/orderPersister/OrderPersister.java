package com.soumen.orderPersister;

import com.soumen.model.Order;

import java.util.List;
import java.util.Map;

/**
 * Defines contract for persisting data from a data source.
 * Implementations class should provide methods to persist the orders in whatever system required.
 */
public interface OrderPersister {
    //This method is responsible for persisting data orders n whatever system required
    void persistDataOrders(Map<String, List<Order>> ordersByCountry);
}
