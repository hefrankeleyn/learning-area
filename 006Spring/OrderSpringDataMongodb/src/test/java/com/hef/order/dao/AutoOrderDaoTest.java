package com.hef.order.dao;

import com.hef.order.db.AutoOrderDao;
import com.hef.order.domain.Order;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class AutoOrderDaoTest {

    @Autowired
    private AutoOrderDao autoOrderDao;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(autoOrderDao);
    }
    @Test
    public void findAllTest(){
        List<Order> all = autoOrderDao.findAll();
        for (Order order: all){
            System.out.println(order);
        }
    }

    @Test
    public void findByCustomer(){
        List<Order> orders = autoOrderDao.findByCustomer("xiaoMing");
        for(Order order: orders){
            System.out.println(order);
            Assert.assertEquals(order.getCustomer(),"xiaoMing");
        }
    }

    @Test
    public void findByCustomerLike(){
        List<Order> orders = autoOrderDao.findByCustomerLike("xiao");
        for(Order order: orders){
            System.out.println(order);
        }
    }

    @Test
    public void findByCustomerAndType(){
        List<Order> orders = autoOrderDao.findByCustomerAndType("xiaoMing", "WEB");
        for(Order order: orders){
            System.out.println(order);
        }
    }

    @Test
    public void findByCustomerLikeAndType(){
        List<Order> orders = autoOrderDao.findByCustomerLikeAndType("Ming", "WEB");
        for(Order order: orders){
            System.out.println(order);
        }
    }

    @Test
    public void findChucksOrdersTest(){
        List<Order> orders = autoOrderDao.findChucksOrders("WEB");
        for(Order order: orders){
            System.out.println(order);
        }
    }

}
