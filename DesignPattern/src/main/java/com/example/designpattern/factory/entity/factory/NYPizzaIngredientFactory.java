package com.example.designpattern.factory.entity.factory;

import com.example.designpattern.factory.entity.ingredient.cheese.Cheese;
import com.example.designpattern.factory.entity.ingredient.cheese.ReggianoCheese;
import com.example.designpattern.factory.entity.ingredient.clams.Clams;
import com.example.designpattern.factory.entity.ingredient.clams.FreshClams;
import com.example.designpattern.factory.entity.ingredient.dough.Dough;
import com.example.designpattern.factory.entity.ingredient.dough.ThinCrustDough;
import com.example.designpattern.factory.entity.ingredient.pepperoni.Pepperoni;
import com.example.designpattern.factory.entity.ingredient.pepperoni.SlicedPepperoni;
import com.example.designpattern.factory.entity.ingredient.sauce.MarinaraSauce;
import com.example.designpattern.factory.entity.ingredient.sauce.Sauce;
import com.example.designpattern.factory.entity.ingredient.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
