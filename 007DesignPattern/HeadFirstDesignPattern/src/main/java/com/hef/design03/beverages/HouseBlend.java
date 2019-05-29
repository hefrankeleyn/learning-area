package com.hef.design03.beverages;

import com.hef.design03.Beverage;

/**
 * @Date 2019-05-29
 * @Author lifei
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
