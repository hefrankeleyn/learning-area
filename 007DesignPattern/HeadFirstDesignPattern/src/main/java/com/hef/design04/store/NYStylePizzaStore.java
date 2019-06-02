package com.hef.design04.store;

import com.hef.design04.Pizza;
import com.hef.design04.PizzaIngredientFactory;
import com.hef.design04.PizzaStore;
import com.hef.design04.ingredient.factory.NYPizzaIngredientFactory;
import com.hef.design04.pizza.NYStyleCheesePizza;
import com.hef.design04.pizza.NYStyleClamPizza;
import com.hef.design04.pizza.NYStylePepperoniPizza;
import com.hef.design04.pizza.NYStyleVeggiePizza;

/**
 * @Date 2019-06-02
 * @Author lifei
 */
public class NYStylePizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        Pizza pizza =null;
        if(type.equals("cheese")){
            pizza = new NYStyleCheesePizza(pizzaIngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if(type.equals("pepperoni")){
            pizza = new NYStylePepperoniPizza(pizzaIngredientFactory);
            pizza.setName("New York Style pepperoni Pizza");
        } else if(type.equals("clam")){
            pizza = new NYStyleClamPizza(pizzaIngredientFactory);
            pizza.setName("New York Style clam Pizza");
        } else if (type.equals("veggie")){
            pizza = new NYStyleVeggiePizza(pizzaIngredientFactory);
            pizza.setName("New York Style veggie Pizza");
        }
        return pizza;
    }
}
