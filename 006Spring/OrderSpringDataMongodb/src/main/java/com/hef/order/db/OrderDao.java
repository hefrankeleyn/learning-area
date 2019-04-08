package com.hef.order.db;

import com.hef.order.domain.Order;

import java.util.List;

public interface OrderDao {

    long count();

    void save(Order order);

    Order findOrderById(String id);

    List<Order> findAllOrders();

    void deleteOrder(Order order);

    List<Order> findOrdersByClient(String client);
    List<Order> findOrdersByClientAndType(String client, String type);
}
