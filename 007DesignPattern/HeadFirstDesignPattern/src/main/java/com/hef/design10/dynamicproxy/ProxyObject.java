package com.hef.design10.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 写代码创建动态代理
 *
 * @Date 2019-06-13
 * @Author lifei
 */
public class ProxyObject {

    /**
     * 创建 OwnerInvocationHandler 的代理
     *
     * @param person
     * @return
     */
    public PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    /**
     * 创建 NonOwnerInvocationHandler 的代理
     *
     * @param person
     * @return
     */
    public PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }


    public PersonBean getProxy(PersonBean person, InvocationHandler handler) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                handler);
    }
}
