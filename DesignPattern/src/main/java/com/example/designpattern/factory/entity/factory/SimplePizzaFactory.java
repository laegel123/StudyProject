package com.example.designpattern.factory.entity.factory;

import com.example.designpattern.factory.entity.pizza.*;

public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new NYCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYPepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYVeggiePizza();
        }

        return pizza;
    }
}
