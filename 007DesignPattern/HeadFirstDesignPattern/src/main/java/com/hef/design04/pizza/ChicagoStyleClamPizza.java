package com.hef.design04.pizza;

import com.hef.design04.Pizza;
import com.hef.design04.PizzaIngredientFactory;
import com.hef.design04.ingredient.Cheese;
import com.hef.design04.ingredient.Dough;
import com.hef.design04.ingredient.Sauce;

/**
 * @Date 2019-06-02
 * @Author lifei
 */
public class ChicagoStyleClamPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public ChicagoStyleClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        Dough dough = ingredientFactory.createDough();
        Sauce sauce = ingredientFactory.createSauce();
        Cheese cheese = ingredientFactory.createCheese();
        System.out.println(dough);
        System.out.println(sauce);
        System.out.println(cheese);

    }
}
