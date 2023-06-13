package com.example.designpattern.command.example2.entity.receiver;

public class Light {
    String position;

    public Light(String position) {
        this.position = position;
    }

    public void on() {
        System.out.println(position + " 불이 켜집니다.");
    }

    public void off() {
        System.out.println(position + " 불이 꺼집니다.");
    }
}
