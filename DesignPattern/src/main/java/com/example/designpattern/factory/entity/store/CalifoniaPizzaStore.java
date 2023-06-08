package com.example.designpattern.factory.entity.store;

import com.example.designpattern.factory.entity.pizza.CalifoniaCheesePizza;
import com.example.designpattern.factory.entity.pizza.CalifoniaClamPizza;
import com.example.designpattern.factory.entity.pizza.CalifoniaPepperoniPizza;
import com.example.designpattern.factory.entity.pizza.Pizza;

public class CalifoniaPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CalifoniaCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new CalifoniaPepperoniPizza();
        } else if (type.equals("clam")) {
            return new CalifoniaClamPizza();
        } else if (type.equals("veggie")) {
            return new CalifoniaCheesePizza();
        } else {
            return null;
        }
    }
}
