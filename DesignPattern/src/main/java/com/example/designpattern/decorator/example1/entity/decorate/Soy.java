package com.example.designpattern.decorator.example1.entity.decorate;

import com.example.designpattern.decorator.example1.entity.Beverage;
import com.example.designpattern.decorator.example1.entity.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 두유";
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
