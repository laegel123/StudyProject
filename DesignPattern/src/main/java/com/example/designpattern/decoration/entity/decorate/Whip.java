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
        double price = beverage.cost();
        if (getSize().equals(Size.TALL)) {
            price += .25;
        } else if (getSize().equals(Size.GRANDE)) {
            price += .35;
        } else if (getSize().equals(Size.VENTI)) {
            price += .45;
        }

        return price;
    }
}
