package com.example.designpattern.decorator.example1.entity;

public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage;

    public Size getSize() {
        return beverage.getSize();
    }
    public abstract String getDescription();
}
