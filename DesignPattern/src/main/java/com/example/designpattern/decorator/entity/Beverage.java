package com.example.designpattern.decorator.entity;

public abstract class Beverage {
    public enum  Size {
        TALL, GRANDE, VENTI,
    }

    public Size size = Size.TALL;
    public String description = "제목 없음";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
