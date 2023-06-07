package com.example.designpattern.decorator.entity.decorate;

import com.example.designpattern.decorator.entity.Beverage;
import com.example.designpattern.decorator.entity.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 모카";
    }

    public double cost() {
        double price = beverage.cost();
        if (getSize().equals(Size.TALL)) {
            price += .20;
        } else if (getSize().equals(Size.GRANDE)) {
            price += .30;
        } else if (getSize().equals(Size.VENTI)) {
            price += .40;
        }

        return price;
    }
}
