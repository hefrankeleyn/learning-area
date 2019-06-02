package com.hef.design04;

import com.hef.design04.factory.SimplePizzaFactory;
/**
 * Factory pattern
 * @Date 2019-06-02
 * @Author lifei
 */
public abstract class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.factory = simplePizzaFactory;
    }

    public PizzaStore(){

    }
    /**
     * 制作pizza
     * @return
     */
    public Pizza orderPizza(String type){
        Pizza pizza =null;
        // 使用简单工厂创建pizza
        /**
         * 简单工厂其实不是一种设计模式， 反而比较像是一种编程习惯。
         * 将创建Pizza的代码放到PizzaStore中，导致没有弹性
         */
//        pizza = factory.createPizza(type);


        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // 创建pizza
    /**
     * 让每个区域类型 都集成这个类
     * 以便 允许子类做决定
     * @param type
     * @return
     */
    public abstract Pizza createPizza(String type);
}
