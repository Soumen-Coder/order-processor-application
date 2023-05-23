package com.soumen.dataReader;

import com.soumen.model.Order;
import com.soumen.orderParser.OrderParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads orders from a CSV file using the DataReader abstraction.
 * Implements the readDataOrders() method to parse the CSV file.
 */

public class CSVDataReaderImpl implements DataReader{

    private final String filePath;
    private final OrderParser orderParser;

    public CSVDataReaderImpl(String filePath, OrderParser orderParser) {
        this.filePath = filePath;
        this.orderParser = orderParser;
    }

    //This method reads data from a dataSource
    @Override
    public List<Order> readDataOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                Order order = orderParser.parseOrder(line);
                if (order != null) {
                    orders.add(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
