package com.hef.order.dao;

import com.hef.order.db.OrderDao;
import com.hef.order.domain.Item;
import com.hef.order.domain.Order;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void shouldNotNull() {
        Assert.assertNotNull(orderDao);
    }

    @Test
    public void saveOrder(){
        Item item = new Item("apple", 2.3, 23);
        Collection<Item> items = new LinkedHashSet<>();
        items.add(item);
        Order order = new Order();
        order.setCustomer("xiaoMing");
        order.setType("WEB");
        order.setItems(items);
        orderDao.save(order);
    }

    @Test
    public void findOrder() {
        Order order = orderDao.findOrderById("5cab4f1cc92c16401418bf8b");
        System.out.println(order);
        Assert.assertNotNull(order);
    }

    @Test
    public void countTest(){
        long count = orderDao.count();
        Assert.assertEquals(1, count);
    }

    @Test
    public void findAllOrders(){
        List<Order> orders = orderDao.findAllOrders();
        for (Order order: orders) {
            System.out.println(order);
        }
    }

    @Test
    public void deleteOneOrders(){
        Order order = orderDao.findOrderById("5caae4f82822425cc2758152");
        orderDao.deleteOrder(order);
    }

    @Test
    public void findOrdersByClientTest(){
        List<Order> orders = orderDao.findOrdersByClient("xiaoMing");
        for (Order order: orders) {
            System.out.println(order);
            Assert.assertEquals(order.getCustomer(), "xiaoMing");
        }
    }
    @Test
    public void findOrdersByClientAndTypeTest(){
        List<Order> orders = orderDao.findOrdersByClientAndType("xiaoMing", "WEB");
        for (Order order: orders) {
            System.out.println(order);
            Assert.assertEquals(order.getCustomer(), "xiaoMing");
            Assert.assertEquals(order.getType(), "WEB");
        }
    }


}
