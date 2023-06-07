package com.example.designpattern.decoration.entity.coffee;

import com.example.designpattern.decoration.entity.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "다크 로스트";
    }

    @Override
    public double cost() {
        double price = 0.0;
        if (getSize().equals(Size.TALL)) {
            price = .99;
        } else if (getSize().equals(Size.GRANDE)) {
            price = 1.20;
        } else if (getSize().equals(Size.VENTI)) {
            price = 1.50;
        }

        return price;
    }
}
