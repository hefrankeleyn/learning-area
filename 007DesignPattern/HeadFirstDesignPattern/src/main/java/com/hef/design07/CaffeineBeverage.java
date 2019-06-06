package com.hef.design07;

/**
 *
 * 咖啡因饮料
 * @Date 2019-06-06
 * @Author lifei
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    /**
     *
     */
    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water.....");
    }

    void pourInCup(){
        System.out.println("Pouring into cup....");
    }
}
