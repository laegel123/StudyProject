package com.example.designpattern.duck.entity;

import com.example.designpattern.duck.entity.fly.FlyWithWings;
import com.example.designpattern.duck.entity.quack.Quack;

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
