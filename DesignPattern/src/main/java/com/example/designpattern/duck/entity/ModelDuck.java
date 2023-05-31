package com.example.designpattern.duck.entity;

import com.example.designpattern.duck.entity.fly.FlyNoWay;
import com.example.designpattern.duck.entity.quack.Quack;

public class ModelDuck extends Duck {

    @Override
    public void display() {
        System.out.println("저는 모형 오리입니다.");
    }

    public ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }
}
