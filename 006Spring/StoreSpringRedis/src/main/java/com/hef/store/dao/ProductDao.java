package com.hef.store.dao;

import com.hef.store.domain.Product;

import java.util.List;
import java.util.Set;

public interface ProductDao {

    void saveProduct(Product product);

    Product getProductByName(String name);

    void deleteProduct(String name);

    long pushLeftListProduct(String listName,Product product);
    long pushRightListProduct(String listName,Product product);
    Product popRightListProduct(String listName);
    Product popLeftListProduct(String listName);

    List<Product> findListProduct(String listName);

    void addSetProduct(String setName, Product product);
    Set<Product> differenceProducts(String setName1, String setName2);
    Set<Product> unionProducts(String setName1, String setName2);
    //
    Set<Product> intersectProducts(String setName1, String setName2);
    void removeSetProducts(String setName, Product product);

    Product randomOneFromSetProducts(String setName);


    Product BoundPopOnePushList(String keyName, Product popOne, List<Product> products);


}
