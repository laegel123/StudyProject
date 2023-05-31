package com.example.designpattern.strategy.entity.quack;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("꽥 !");
    }
}
