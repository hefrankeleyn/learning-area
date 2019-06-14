package com.hef.design10.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date 2019-06-13
 * @Author lifei
 */
public class OwnerInvocationHandler implements InvocationHandler {

    private PersonBean person;

    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {

        try{
            if (method.getName().startsWith("get")){
                return method.invoke(person, args);
            } else if(method.getName().equals("setHotOrNotRating")){
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")){
                return method.invoke(person, args);
            }
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
}
