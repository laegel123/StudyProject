package com.example.designpattern.factory.entity.store;

import com.example.designpattern.factory.entity.factory.ChicagoIngredientFactory;
import com.example.designpattern.factory.entity.factory.PizzaIngredientFactory;
import com.example.designpattern.factory.entity.pizza.*;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new ChicagoIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("시카고 스타일 치즈 피자");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("시카고 스타일 페퍼로니 피자");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("시카고 스타일 조개 피자");
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("시카고 스타일 야채 피자");
        } else {
            return null;
        }


        return null;
    }
}
