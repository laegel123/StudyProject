package com.example.designpattern.decoration.entity.coffee;

import com.example.designpattern.decoration.entity.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "에스프레소";
    }

    @Override
    public double cost() {

        double price = 0.0;
        if (getSize().equals(Size.TALL)) {
            price = 1.99;
        } else if (getSize().equals(Size.GRANDE)) {
            price = 2.5;
        } else if (getSize().equals(Size.VENTI)) {
            price = 3.0;
        }

        return price;
    }

}
