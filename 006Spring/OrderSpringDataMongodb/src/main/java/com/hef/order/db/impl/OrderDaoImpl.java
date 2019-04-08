package com.hef.order.db.impl;

import com.hef.order.db.OrderDao;
import com.hef.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    MongoOperations mongoOperations;
    @Override
    public long count() {
        long orderCount = mongoOperations.getCollection("order").count();
        return orderCount;
    }

    @Override
    public void save(Order order) {
        mongoOperations.save(order, "order");
    }

    @Override
    public Order findOrderById(String id) {
        Order order = mongoOperations.findById(id, Order.class);
        return order;
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> all = mongoOperations.findAll(Order.class);
        return all;
    }

    @Override
    public void deleteOrder(Order order) {
        mongoOperations.remove(order);
    }

    @Override
    public List<Order> findOrdersByClient(String client) {
        List<Order> orders = mongoOperations.find(Query.query(Criteria.where("customer").is(client)), Order.class);
        return orders;
    }

    @Override
    public List<Order> findOrdersByClientAndType(String client, String type) {
        List<Order> orders = mongoOperations.find(Query.query(Criteria.where("customer").is(client)
                .and("type").is(type)), Order.class);
        return orders;
    }
}
