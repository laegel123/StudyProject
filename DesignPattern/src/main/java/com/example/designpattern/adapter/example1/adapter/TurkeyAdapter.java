package com.example.designpattern.adapter.example1.adapter;

import com.example.designpattern.adapter.example1.entity.Duck;
import com.example.designpattern.adapter.example1.entity.Turkey;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
