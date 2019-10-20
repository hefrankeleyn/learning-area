package com.hef.test;

import com.hef.algorithms.fundamentals.symboltable.BinarySearchST;
import com.hef.algorithms.fundamentals.symboltable.SequentialSearchST;
import org.junit.Test;

/**
 * @Date 2019/10/20
 * @Author lifei
 */
public class SequentialSearchTest {

    @Test
    public void test01(){
        SequentialSearchST<String, String> symbolTable = new SequentialSearchST<>();
        symbolTable.put("aa", "bb");
        System.out.println(symbolTable.get("aa"));
    }

    @Test
    public void binarySearchTest(){
        BinarySearchST<Integer, String> bst = new BinarySearchST<>(10);
        bst.put(2, "bb");
        bst.put(6, "cc");
        System.out.println(bst.get(7));
        System.out.println(bst.get(2));
        System.out.println(bst.get(6));
    }
}
