package com.hef.design10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    private static final long serialVersionUID = -271947229644133464L;
    /**
     * 设计一个不带参数的构造器，并声明 RemoteException
     * @throws RemoteException
     */
    protected MyRemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, 'Hey'";
    }
}
