package com.example.designpattern.adapter.example1.adapter;

import com.example.designpattern.adapter.example1.entity.Duck;
import com.example.designpattern.adapter.example1.entity.Turkey;

public class DuckAdapter implements Turkey {
    Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
