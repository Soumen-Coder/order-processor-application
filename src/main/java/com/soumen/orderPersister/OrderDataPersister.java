package com.soumen.orderPersister;

import com.soumen.model.Order;

import java.util.List;
import java.util.Map;

public class OrderDataPersister {
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

    private void persistDataOrder(Order order) {
        //Can be persisted to a database later
        System.out.println(order);
    }
}
