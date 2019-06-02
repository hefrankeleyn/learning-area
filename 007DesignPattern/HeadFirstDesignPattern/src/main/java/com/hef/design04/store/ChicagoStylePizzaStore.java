package com.hef.design04.store;

import com.hef.design04.Pizza;
import com.hef.design04.PizzaIngredientFactory;
import com.hef.design04.PizzaStore;
import com.hef.design04.factory.SimplePizzaFactory;
import com.hef.design04.ingredient.factory.ChicagoPizzaIngredientFactory;
import com.hef.design04.ingredient.factory.NYPizzaIngredientFactory;
import com.hef.design04.pizza.ChicagoStyleCheesePizza;
import com.hef.design04.pizza.ChicagoStyleClamPizza;
import com.hef.design04.pizza.ChicagoStylePepperoniPizza;
import com.hef.design04.pizza.ChicagoStyleVeggiePizza;

/**
 * @Date 2019-06-02
 * @Author lifei
 */
public class ChicagoStylePizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {
        Pizza pizza =null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        if(type.equals("cheese")){
            pizza = new ChicagoStyleCheesePizza(pizzaIngredientFactory);

        } else if(type.equals("pepperoni")){
            pizza = new ChicagoStylePepperoniPizza(pizzaIngredientFactory);
        } else if(type.equals("clam")){
            pizza = new ChicagoStyleClamPizza(pizzaIngredientFactory);
        } else if (type.equals("veggie")){
            pizza = new ChicagoStyleVeggiePizza(pizzaIngredientFactory);
        }
        return pizza;
    }
}
