package com.hef.design03.beverages;

import com.hef.design03.Beverage;

/**
 * 浓缩咖啡
 * 1. 首先让 Espresso 拓展自Beverage类，因为Espresso是一种饮料
 * @Date 2019-05-29
 * @Author lifei
 */
public class Espresso extends Beverage {

    /**
     * description 继承自 Beverage
     */
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
