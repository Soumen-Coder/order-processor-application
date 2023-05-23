package com.soumen.orderParser;

import com.soumen.model.Order;

public interface OrderParser {
    Order parseOrder(String line);
}
