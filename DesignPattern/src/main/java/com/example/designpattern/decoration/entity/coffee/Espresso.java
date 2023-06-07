package com.example.designpattern.decoration.entity.coffee;

import com.example.designpattern.decoration.entity.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "에스프레소";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
