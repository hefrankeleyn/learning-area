package com.hef.order.db;

import com.hef.order.domain.Order;

import java.util.List;

public interface OrderOperations {
    List<Order> findOrdersByType(String t);
}
