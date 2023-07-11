package com.example.designpattern.templateMethodPattern.after;

import com.example.designpattern.templateMethodPattern.before.Direction;
import com.example.designpattern.templateMethodPattern.before.Door;
import com.example.designpattern.templateMethodPattern.before.DoorStatus;
import com.example.designpattern.templateMethodPattern.before.MotorStatus;

public abstract class Motor {

    private Door door;
    private MotorStatus motorStatus;

    public Motor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() { return motorStatus; }
    private void setMotorStatus(MotorStatus motorStatus) { this.motorStatus = motorStatus; }

    /*
    템플릿 메서드로 추출
     */
    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus();
        // 이미 이동 중이면 아무 작업을 하지 않음
        if (motorStatus == MotorStatus.MOVING) return;

        DoorStatus doorStatus = door.getDoorStatus();
        // 만약 문이 열려 있으면 우선 문을 닫음
        if (doorStatus == DoorStatus.OPENED) door.close();

        // hook method
        moveMotor(direction);
        // 모터 상태를 이동 중으로 변경함
        setMotorStatus(MotorStatus.MOVING);
    }

    // hook method
    public abstract void moveMotor(Direction direction);
}
