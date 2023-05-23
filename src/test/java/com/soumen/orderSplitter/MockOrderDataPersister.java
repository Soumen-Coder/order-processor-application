package com.soumen.orderSplitter;

import com.soumen.model.Order;
import com.soumen.orderPersister.OrderPersister;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class MockOrderDataPersister implements OrderPersister {

    private boolean persistOrdersCalled;
    private Map<String, List<Order>> persistedOrdersMap;

    @Override
    public void persistDataOrders(Map<String, List<Order>> ordersByCountry) {
        this.persistOrdersCalled = true;
        this.persistedOrdersMap = ordersByCountry;
    }

    public boolean isPersistOrdersCalled() {
        return persistOrdersCalled;
    }

    public Map<String, List<Order>> getPersistedOrders() {
        return persistedOrdersMap;
    }

}