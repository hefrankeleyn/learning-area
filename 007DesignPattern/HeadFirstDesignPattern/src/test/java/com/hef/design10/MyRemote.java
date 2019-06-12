package com.hef.design10;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * 步骤一： 制作远程接口
 */
public interface MyRemote extends Remote {

    /**
     * 每次远程方法调用都必须考虑成是“有风险”的。
     * 在方法上声明RemoteException， 可以让客户注意到这件事，
     * 并了解这可能是无法工作的。
     * @return  确定变量和返回值是属于愿于（primitive）类型或者可序列化（Serializable）类型。
     * @throws RemoteException
     */
    String sayHello() throws RemoteException;
}
