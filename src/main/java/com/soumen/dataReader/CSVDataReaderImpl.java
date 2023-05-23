package com.soumen.dataReader;

import com.soumen.model.Order;
import com.soumen.orderParser.OrderParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReaderImpl implements DataReader{

    private final String filePath;
    private final OrderParser orderParser;

    public CSVDataReaderImpl(String filePath, OrderParser orderParser) {
        this.filePath = filePath;
        this.orderParser = orderParser;
    }
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
