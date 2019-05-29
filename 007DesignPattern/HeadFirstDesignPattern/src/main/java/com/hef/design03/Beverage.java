package com.hef.design03;

/**
 * 饮料
 * @Date 2019-05-29
 * @Author lifei
 */
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
