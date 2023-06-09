package com.example.designpattern.factory.entity.factory;

import com.example.designpattern.factory.entity.ingredient.cheese.Cheese;
import com.example.designpattern.factory.entity.ingredient.clams.Clams;
import com.example.designpattern.factory.entity.ingredient.dough.Dough;
import com.example.designpattern.factory.entity.ingredient.pepperoni.Pepperoni;
import com.example.designpattern.factory.entity.ingredient.sauce.Sauce;
import com.example.designpattern.factory.entity.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClams();
    
}
