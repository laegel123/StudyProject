package com.example.designpattern.decoration.entity.coffee;

import com.example.designpattern.decoration.entity.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        description = "디카페인";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
