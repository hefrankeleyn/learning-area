package com.hef.aop.aspect05;

public class DefaultEncoreable implements Encoreable{
    @Override
    public void performEncore() {
        System.out.println("This is new function that about encore.");
    }
}
