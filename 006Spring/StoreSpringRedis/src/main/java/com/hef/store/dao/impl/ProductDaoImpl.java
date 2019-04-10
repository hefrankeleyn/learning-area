package com.hef.store.dao.impl;

import com.hef.store.dao.ProductDao;
import com.hef.store.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;
    @Override
    public void saveProduct(Product product) {
        redisTemplate.opsForValue().set(product.getName(), product);
    }

    @Override
    public Product getProductByName(String name) {
        return redisTemplate.opsForValue().get(name);
    }

    @Override
    public void deleteProduct(String name) {
        redisTemplate.delete(name);
    }

    @Override
    public long pushLeftListProduct(String listName, Product product) {
        Long a = redisTemplate.opsForList().rightPush(listName, product);
        return a;
    }

    @Override
    public long pushRightListProduct(String listName, Product product) {
        return redisTemplate.opsForList().leftPush(listName, product);
    }

    @Override
    public Product popRightListProduct(String listName) {
        return redisTemplate.opsForList().rightPop(listName);
    }

    @Override
    public Product popLeftListProduct(String listName) {
        return redisTemplate.opsForList().leftPop(listName);
    }

    @Override
    public List<Product> findListProduct(String listName) {
        return redisTemplate.opsForList().range(listName, 0, redisTemplate.opsForList().size(listName));
    }

    @Override
    public void addSetProduct(String setName, Product product) {
        redisTemplate.opsForSet().add(setName, product);
    }

    @Override
    public Set<Product> differenceProducts(String setName1, String setName2) {
        return redisTemplate.opsForSet().difference(setName1, setName2);
    }

    @Override
    public Set<Product> unionProducts(String setName1, String setName2) {
        return redisTemplate.opsForSet().union(setName1, setName2);
    }

    @Override
    public Set<Product> intersectProducts(String setName1, String setName2) {
        return redisTemplate.opsForSet().intersect(setName1, setName2);
    }

    @Override
    public void removeSetProducts(String setName, Product product) {
        redisTemplate.opsForSet().remove(setName, product);
    }

    @Override
    public Product randomOneFromSetProducts(String setName) {
        return redisTemplate.opsForSet().randomMember(setName);
    }

    @Override
    public Product BoundPopOnePushList(String keyName, Product popOne, List<Product> products) {
        BoundListOperations<String, Product> boundListOps = redisTemplate.boundListOps(keyName);
        Product popProduct = boundListOps.rightPop();
        for (Product p:
             products) {
            boundListOps.rightPush(p);
        }
        return popProduct;
    }


}
