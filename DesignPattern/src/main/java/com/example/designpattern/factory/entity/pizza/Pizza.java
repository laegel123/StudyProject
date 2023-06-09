package com.example.designpattern.factory.entity.pizza;

import com.example.designpattern.factory.entity.ingredient.cheese.Cheese;
import com.example.designpattern.factory.entity.ingredient.clams.Clams;
import com.example.designpattern.factory.entity.ingredient.dough.Dough;
import com.example.designpattern.factory.entity.ingredient.pepperoni.Pepperoni;
import com.example.designpattern.factory.entity.ingredient.sauce.Sauce;
import com.example.designpattern.factory.entity.ingredient.veggies.Veggies;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    public String name;

    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("175 도에서 25분 간 굽기");
    };


    public void cut() {
        System.out.println("피자를 사선으로 자르기");
    }

    public void box() {
        System.out.println("상자에 피자 담기");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
