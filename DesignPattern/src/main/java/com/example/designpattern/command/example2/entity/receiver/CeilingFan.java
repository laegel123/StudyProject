package com.example.designpattern.command.example2.entity.receiver;

public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String position;
    int speed;

    public CeilingFan(String position) {
        this.position = position;
        this.speed = OFF;
    }

    public void setHigh() {
        speed = HIGH;
    }

    public void setMedium() {
        speed = MEDIUM;
    }

    public void setLow() {
        speed = LOW;
    }

    public void off() {
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }
}
