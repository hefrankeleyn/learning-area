package com.hef.order.db.impl;

import com.hef.order.db.OrderOperations;
import com.hef.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class AutoOrderDaoImpl implements OrderOperations {

    @Autowired
    private MongoOperations mongoOperations;
    @Override
    public List<Order> findOrdersByType(String t) {
        String type = t.equals("NET")? "WEB": t;

        return mongoOperations.find(Query.query(Criteria.where("type").is(type)), Order.class);
    }
}
