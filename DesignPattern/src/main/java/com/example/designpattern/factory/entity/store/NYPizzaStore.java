package com.example.designpattern.factory.entity.store;

import com.example.designpattern.factory.entity.pizza.*;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYPepperoniPizza();
        } else if (type.equals("clam")) {
            return new NYClamPizza();
        } else if (type.equals("veggie")) {
            return new NYVeggiePizza();
        } else {
            return null;
        }
    }
}
