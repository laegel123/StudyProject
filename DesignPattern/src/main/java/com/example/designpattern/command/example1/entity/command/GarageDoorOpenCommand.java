package com.example.designpattern.command.example1.entity.command;

import com.example.designpattern.command.example1.entity.behavior.GarageDoor;

public class GarageDoorOpenCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.lightOn();
    }
}
