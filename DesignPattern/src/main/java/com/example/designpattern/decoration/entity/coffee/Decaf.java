package com.example.designpattern.decoration.entity.coffee;

import com.example.designpattern.decoration.entity.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        description = "디카페인";
    }

    @Override
    public double cost() {
        double price = 0.0;
        if (getSize().equals(Size.TALL)) {
            price = 1.05;
        } else if (getSize().equals(Size.GRANDE)) {
            price = 1.35;
        } else if (getSize().equals(Size.VENTI)) {
            price = 1.55;
        }

        return price;
    }
}
