package com.example.designpattern.adapter.example1.entity;

public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("골골");
    }

    @Override
    public void fly() {
        System.out.println("날고 있다.");
    }
}
