package com.vscodes;

import java.io.UnsupportedEncodingException;

/**
 * PrimitiveTypeTest
 */
public class PrimitiveTypeTest {

    public static void main(String[] args) {
        // test01();
        // test02();
        try {
            test04();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void test04() throws UnsupportedEncodingException {
        String greeting = "Hello";
        String codeStr = "\uD835\uDD46";
        byte[] b = codeStr.getBytes("UTF-16");
        String s = new String(b, "UTF-16");
        System.out.println("greeting："+greeting);
        System.out.println("一个UTF-16编码的特殊符号s："+s);
        System.out.println("greeting.length() : " + greeting.length());   // 打印出 5
        System.out.println("greeting.codePointCount() : " + greeting.codePointCount(0, greeting.length()));   // 打印出5
        System.out.println("s.length() : " + s.length());  // 打印出 2
        System.out.println("s.codePointCount() : " + s.codePointCount(0, s.length()));  // 打印出 1
    }

    public static void test03() {
        String a = "aa";
    }

    public static void test02() {
        String s1 = "hello world";
        String s2 = "hel";
        String s3 = s1.concat(s2);
        System.out.println(s3);
    }

    public static void test01(){
        double d = 1.0e+4; // 10000.0
        double d2 = 100000.0e-4; // 10.0
        double d3 = 1.0e-4; // 
        double a1 = 0x1.0p+3; // 8.0
        double a2 = 0x1.0p-3; // 0.125
        System.out.println(d);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(Double.NaN);
        //Double.isNaN(v);
    }
}