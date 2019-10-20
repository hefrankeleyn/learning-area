package com.hef.test;

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
}
