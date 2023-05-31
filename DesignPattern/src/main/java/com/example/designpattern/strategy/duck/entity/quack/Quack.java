package com.example.designpattern.duck.entity.quack;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("꽥 !");
    }
}
