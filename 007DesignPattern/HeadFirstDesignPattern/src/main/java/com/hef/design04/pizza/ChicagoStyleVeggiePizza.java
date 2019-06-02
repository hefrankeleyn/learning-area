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
public class ChicagoStyleVeggiePizza extends Pizza {

    /*public ChicagoStyleVeggiePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    public void cut(){
        System.out.println("Cutting the pizza into square slices");
    }*/

    private PizzaIngredientFactory ingredientFactory;

    public ChicagoStyleVeggiePizza(PizzaIngredientFactory ingredientFactory) {
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
