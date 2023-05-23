package com.soumen.orderPersister;

import com.soumen.model.Order;

import java.util.List;
import java.util.Map;

/**
 * Persists orders in the system, as of now it is just a console output but can be extended to persist order in database.
 * Implements the OrderDataPersister Interface for handling order persistence operations.
 */
public class OrderDataPersister implements OrderPersister {
    //This method is responsible for persisting data orders n whatever system required
    @Override
    public void persistDataOrders(Map<String, List<Order>> ordersByCountry) {
        for (Map.Entry<String, List<Order>> entry : ordersByCountry.entrySet()) {
            String country = entry.getKey();
            List<Order> orders = entry.getValue();

            // Persist orders for the country
            System.out.println("Persisting orders for " + country + ":");
            for (Order order : orders) {
                persistDataOrder(order);
            }
            System.out.println();
        }
    }

    //Inner method to persist single order
    private void persistDataOrder(Order order) {
        //Can be persisted to a database later
        System.out.println(order);
    }
}
