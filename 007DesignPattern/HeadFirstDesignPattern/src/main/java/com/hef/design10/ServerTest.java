package com.hef.design10;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Date 2019-06-09
 * @Author lifei
 */
public class ServerTest {

    public static void main(String[] args) {

        MyRemote myRemote=null;
        try{
            LocateRegistry.createRegistry(1199);
            myRemote = new MyRemoteImpl();
            Naming.bind("rmi://127.0.0.1:1199/hello", myRemote);
            System.out.println("server ok...");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
