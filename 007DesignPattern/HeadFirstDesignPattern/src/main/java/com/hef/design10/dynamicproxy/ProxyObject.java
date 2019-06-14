package com.hef.design10.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Date 2019-06-13
 * @Author lifei
 */
public class ProxyObject {

    public PersonBean getOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    public PersonBean getNonOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),new NonOwnerInvocationHandler(person));
    }


    public PersonBean getProxy(PersonBean person, InvocationHandler handler){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                handler);
    }



}
