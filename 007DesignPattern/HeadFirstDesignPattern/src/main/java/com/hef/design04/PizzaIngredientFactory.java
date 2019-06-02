package com.hef.design04;

import com.hef.design04.ingredient.*;

/**
 * @Date 2019-06-02
 * @Author lifei
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
