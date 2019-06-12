package com.hef.design10;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class ClientTest {

    public static void main(String[] args) {
        try {
            MyRemote remote = (MyRemote) Naming.lookup("rmi://127.0.0.1:1199/hello");
            System.out.println(remote.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
