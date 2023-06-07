package com.example.designpattern.decoration.entity.decorate;

import com.example.designpattern.decoration.entity.Beverage;
import com.example.designpattern.decoration.entity.CondimentDecorator;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 휘핑크림";
    }

    public double cost() {
        return beverage.cost() + .25;
    }
}
