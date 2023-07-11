package com.example.designpattern.templateMethodPattern.before;

;
public class Door {
    private DoorStatus doorStatus;

    public Door(DoorStatus doorStatus) {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void open() {
        this.doorStatus = DoorStatus.OPENED;
    }

    public void close() {
        this.doorStatus = DoorStatus.CLOSED;
    }
}
