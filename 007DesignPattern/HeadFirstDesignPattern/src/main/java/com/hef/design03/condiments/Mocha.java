package com.hef.design03.condiments;

import com.hef.design03.Beverage;
import com.hef.design03.CondimentDecorator;

/**
 * @Date 2019-05-29
 * @Author lifei
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
