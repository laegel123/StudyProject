package com.example.designpattern.decoration.entity;

public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage;

    public abstract String getDescription();
}
