package com.hef.design03;

import com.hef.design03.beverages.Espresso;
import com.hef.design03.beverages.HouseBlend;
import com.hef.design03.condiments.Mocha;

/**
 *
 * 装饰者模式
 * @Date 2019-05-29
 * @Author lifei
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " ￥" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);

        System.out.println(beverage2.getDescription() + " ￥" + beverage2.cost());
    }
}
