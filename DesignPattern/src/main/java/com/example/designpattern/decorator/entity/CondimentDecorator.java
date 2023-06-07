package com.example.designpattern.decorator.entity;

public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage;

    public Size getSize() {
        return beverage.getSize();
    }
    public abstract String getDescription();
}
