package com.example.designpattern.templateMethodPattern.after;

import com.example.designpattern.templateMethodPattern.before.Direction;
import com.example.designpattern.templateMethodPattern.before.Door;

public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    public void moveMotor(Direction direction) {
        // 구현
    }
}
