package com.hef.order.db;

import com.hef.order.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * 使用Spring Data Repository 来创建 Repository
 */
public interface AutoOrderDao extends MongoRepository<Order, String> {

    // 添加自定义的查询方法
    List<Order> findByCustomer(String customer);
    List<Order> findByCustomerLike(String c);
    List<Order> findByCustomerAndType(String customer, String type);
    List<Order> findByCustomerLikeAndType(String c, String t);

    // 指定查询
    @Query("{'customer': 'xiaoMing', 'type':?0}")
    List<Order> findChucksOrders(String type);
}
