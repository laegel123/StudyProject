package com.example.designpattern.templateMethodPattern.after;

import com.example.designpattern.templateMethodPattern.before.Direction;
import com.example.designpattern.templateMethodPattern.before.Door;

public class LGMotor extends Motor {

    public LGMotor(Door door) {
        super(door);
    }

    @Override
    public void moveMotor(Direction direction) {
        // 구현
    }
}
