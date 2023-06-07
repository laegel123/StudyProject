package com.example.designpattern.decorator.example1.entity.coffee;

import com.example.designpattern.decorator.example1.entity.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "하우스 블랜드 커피";
    }

    @Override
    public double cost() {

        double price = 0.0;
        if (getSize().equals(Size.TALL)) {
            price = .89;
        } else if (getSize().equals(Size.GRANDE)) {
            price = 1.3;
        } else if (getSize().equals(Size.VENTI)) {
            price = 1.8;
        }

        return price;
    }
}
