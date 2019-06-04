package com.hef.design04.factory;

import com.hef.design04.Pizza;
import com.hef.design04.ingredient.factory.ChicagoPizzaIngredientFactory;
import com.hef.design04.pizza.CheesePizza;
import com.hef.design04.pizza.GreekPizza;
import com.hef.design04.pizza.PepperoniPizza;

/**
 * 简单工厂
 * @Date 2019-06-02
 * @Author lifei
 */
public class SimplePizzaFactory {

    /**
     * 创建pizza
     * 简单工厂， 这样做，制作比萨的代码绑定到PizzaStra中，没有弹性
     * @param type
     * @return
     */
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equals("cheese")){
            pizza = new CheesePizza(new ChicagoPizzaIngredientFactory());
        }else if (type.equals("greek")){
            pizza = new GreekPizza(new ChicagoPizzaIngredientFactory());
        }else if (type.equals("pepperoni")){
            pizza = new PepperoniPizza(new ChicagoPizzaIngredientFactory());
        }
        return pizza;
    }
}
