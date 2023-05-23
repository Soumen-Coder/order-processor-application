package com.soumen.orderPersister;

import com.soumen.model.Order;
import com.soumen.orderSplitter.OrderSplitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockOrderDataSplitter implements OrderSplitter {

    private boolean IsSplitOrdersCalled;
    private List<Order> splitOrdersInput;

    @Override
    public Map<String, List<Order>> splitDataOrdersByCountry(List<Order> orders) {
        this.IsSplitOrdersCalled = true;
        this.splitOrdersInput = orders;

        return new HashMap<>();
    }

    public boolean isSplitOrdersCalled() {
        return IsSplitOrdersCalled;
    }

    public List<Order> getSplitOrdersInput() {
        return splitOrdersInput;
    }

}