package com.hef.design10.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date 2019-06-13
 * @Author lifei
 */
public class NonOwnerInvocationHandler implements InvocationHandler {

    private PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {

            if (method.getName().equals("setHotOrNotRating")) {
                return method.invoke(person, args);
            }else if(method.getName().startsWith("set")){
                throw new IllegalAccessException();
            }else if(method.getName().startsWith("get")){
                return method.invoke(person, args);
            }
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
}
