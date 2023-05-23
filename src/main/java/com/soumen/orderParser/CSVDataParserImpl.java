package com.soumen.orderParser;

import com.soumen.model.Order;

/**
 * Parses order data from CSV data source and returns Order objects.
 * Implements the OrderParser Interface for handling order parsing operations.
 */
public class CSVDataParserImpl implements OrderParser{
    private static final String CSV_SEPARATOR = ",";

    //This method is responsible for parsing data orders.
    @Override
    public Order parseOrder(String line) {
        String[] data = line.split(CSV_SEPARATOR);
        if (data.length == 4) {
            String orderId = data[0].trim();
            String emailId = data[1].trim();
            String phoneNumber = data[2].trim();
            Double parcelWeight = Double.parseDouble(data[3].trim());
            return new Order(orderId, emailId, phoneNumber, parcelWeight);
        }
        return null;
    }
}
