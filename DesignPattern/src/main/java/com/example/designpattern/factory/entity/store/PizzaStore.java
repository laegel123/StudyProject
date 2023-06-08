package com.example.designpattern.factory.entity.store;

import com.example.designpattern.factory.entity.pizza.Pizza;

public abstract class PizzaStore {

    public final Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // factory method
    abstract Pizza createPizza(String type);
}
