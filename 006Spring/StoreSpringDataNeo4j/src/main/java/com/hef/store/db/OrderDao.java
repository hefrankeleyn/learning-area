package com.hef.store.db;


import com.hef.store.domain.Order;

import java.util.List;

public interface OrderDao {

    void saveOrder(Order order);

    Order findOne(Long id);

    List<Order> findAll();

    long count();

    void deleteOrder(Order order);
}
