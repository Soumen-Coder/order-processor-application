package com.soumen.orderSplitter;

import com.soumen.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDataSplitter {
    private static final Map<String, String> COUNTRY_REGEX_MAP = new HashMap<>();

    static {
        COUNTRY_REGEX_MAP.put("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$");
        COUNTRY_REGEX_MAP.put("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$");
        COUNTRY_REGEX_MAP.put("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$");
        COUNTRY_REGEX_MAP.put("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$");
        COUNTRY_REGEX_MAP.put("Uganda", "\\(256\\)\\ ?\\d{9}$");
    }

    public Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders) {
        Map<String, List<Order>> ordersByCountry = new HashMap<>();
        for (Order order : orders) {
            String country = determineCountry(order.getPhoneNumber());
            ordersByCountry.computeIfAbsent(country, key -> new ArrayList<>()).add(order);
        }
        return ordersByCountry;
    }

    private String determineCountry(String phoneNumber) {
        for (Map.Entry<String, String> entry : COUNTRY_REGEX_MAP.entrySet()) {
            String country = entry.getKey();
            String regex = entry.getValue();
            if (phoneNumber.matches(regex)) {
                return country;
            }
        }
        return "Cannot determine the country";
    }
}
