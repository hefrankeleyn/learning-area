package com.vscodes;

/**
 * DebugTest
 */
public class DebugTest {

    public static void main(String[] args) {
        //test01();
        //conditionBreakPoint();
        test02();
    }

    private static void test01() {
        System.out.println("Please input your name:");
        String s = "aa";
        int l = s.length();
        System.out.println(s);
    }
    private static void test02(){
        String s2 = "aa";
        String s1 = "bbb";
        System.out.println(s1);
    }

    private static void conditionBreakPoint(){
        int i =0;
        for (; i < 100; i++) {
            System.out.print(".");
        }
        System.out.println();
        System.out.println("Hello world!");
    }
}