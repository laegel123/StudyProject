package com.example.designpattern.command.example1.entity.command;

import com.example.designpattern.command.example1.entity.behavior.Light;

public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
