package com.example.designpattern.decoration.entity.decorate;

import com.example.designpattern.decoration.entity.Beverage;
import com.example.designpattern.decoration.entity.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 모카";
    }

    public double cost() {
        return beverage.cost() + .20;
    }
}
