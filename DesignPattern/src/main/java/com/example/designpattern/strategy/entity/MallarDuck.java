package com.example.designpattern.strategy.entity;

import com.example.designpattern.strategy.entity.fly.FlyWithWings;
import com.example.designpattern.strategy.entity.quack.Quack;

public class MallarDuck extends Duck{
    @Override
    public void display() {
        System.out.println("저는 물오리입니다.");
    }

    public MallarDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
}
