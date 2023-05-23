package com.soumen.orderSplitter;

import com.soumen.exception.OrderProcessException;
import com.soumen.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Splits the order based on the country name
 * Implements the OrderSplitter Interface for splitting operation.
 */
public class OrderDataSplitter implements OrderSplitter {
    private static final Map<String, String> COUNTRY_REGEX_MAP = new HashMap<>();

    //Static block, runs once when the class loads.
    //It has the keys as the country names and the regex expression as values
    static {
        COUNTRY_REGEX_MAP.put("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$");
        COUNTRY_REGEX_MAP.put("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$");
        COUNTRY_REGEX_MAP.put("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$");
        COUNTRY_REGEX_MAP.put("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$");
        COUNTRY_REGEX_MAP.put("Uganda", "\\(256\\)\\ ?\\d{9}$");
    }

    //This method splits the data based on the country
    @Override
    public Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders) {
        Map<String, List<Order>> ordersByCountry = new HashMap<>();
        for (Order order : orders) {
            String country = determineCountry(order.getPhoneNumber());
            ordersByCountry.computeIfAbsent(country, key -> new ArrayList<>()).add(order);
        }
        return ordersByCountry;
    }

    //This method determines the country via phoneNumber with the help of COUNTRY_REGEX_MAP
    private String determineCountry(String phoneNumber) {
        for (Map.Entry<String, String> entry : COUNTRY_REGEX_MAP.entrySet()) {
            String country = entry.getKey();
            String regex = entry.getValue();
            if (phoneNumber.matches(regex)) {
                return country;
            }
        }
        throw new OrderProcessException("Cannot determine Country!!!");
    }
}
