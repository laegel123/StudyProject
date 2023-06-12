package com.example.designpattern.factory.entity.factory;

import com.example.designpattern.factory.entity.ingredient.cheese.Cheese;
import com.example.designpattern.factory.entity.ingredient.cheese.MozzarellaCheese;
import com.example.designpattern.factory.entity.ingredient.clams.Clams;
import com.example.designpattern.factory.entity.ingredient.clams.FreshClams;
import com.example.designpattern.factory.entity.ingredient.dough.Dough;
import com.example.designpattern.factory.entity.ingredient.dough.ThickCrustDough;
import com.example.designpattern.factory.entity.ingredient.pepperoni.Pepperoni;
import com.example.designpattern.factory.entity.ingredient.pepperoni.SlicedPepperoni;
import com.example.designpattern.factory.entity.ingredient.sauce.PlumTomatoSauce;
import com.example.designpattern.factory.entity.ingredient.sauce.Sauce;
import com.example.designpattern.factory.entity.ingredient.veggies.*;

public class ChicagoIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Spinach(), new EggPlant(), new BlackOlives(), new Garlic(), new RedPepper(), new Onion()};
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
