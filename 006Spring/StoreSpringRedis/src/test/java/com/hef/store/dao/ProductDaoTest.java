package com.hef.store.dao;

import com.hef.store.domain.Product;
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
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(productDao);
    }

    @Test
    public void saveProductTest(){
        Product product = new Product();
        product.setName("world");
        product.setDescription("can eat.");
        product.setPrice(23.3);
        productDao.saveProduct(product);
    }

    @Test
    public void getProductTest(){
        Product apple = productDao.getProductByName("world");
        System.out.println(apple);
        Assert.assertNotNull(apple);
    }

    @Test
    public void deleteProduct(){
        productDao.deleteProduct("123");
    }

    @Test
    public void rightPushProduct() {
        Product product = new Product();
        product.setName("apple01");
        product.setDescription("can eat.");
        product.setPrice(23.3);
        long length = productDao.pushRightListProduct("appleCar", product);
        System.out.println("length: " + length);
    }
    @Test
    public void leftPushProduct() {
        Product product = new Product();
        product.setName("apple02");
        product.setDescription("can eat.");
        product.setPrice(23.3);
        long length = productDao.pushLeftListProduct("appleCar", product);
    }
    @Test
    public void listProductTest(){
        List<Product> listProduct = productDao.findListProduct("appleCar");
        for (Product p:
             listProduct) {
            System.out.println(p);
        }
    }
    @Test
    public void rightPopProduct(){
        Product first = productDao.popLeftListProduct("appleCar");
        System.out.println(first);
        Assert.assertEquals("apple02", first.getName());
    }
    @Test
    public void popRightListProduct() {
        Product first = productDao.popRightListProduct("appleCar");
        System.out.println(first);
        Assert.assertEquals("apple02", first.getName());
    }
}
