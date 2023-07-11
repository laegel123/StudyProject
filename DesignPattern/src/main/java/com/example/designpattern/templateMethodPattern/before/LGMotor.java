package com.example.designpattern.templateMethodPattern.before;

public class LGMotor {
    private Door door;
    private MotorStatus motorStatus;

    public LGMotor(Door door) {
        this.door = door;
        motorStatus = MotorStatus.STOPPED; // 초기: 멈춘 상태
    }
    private void moveLGMotor(Direction direction) {
        // LG Motor를 구동시킴
    }
    public MotorStatus getMotorStatus() { return motorStatus; }
    private void setMotorStatus(MotorStatus motorStatus) { this.motorStatus = motorStatus; }

    /* 엘리베이터 제어 */
    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus();
        // 이미 이동 중이면 아무 작업을 하지 않음
        if (motorStatus == MotorStatus.MOVING) return;

        DoorStatus doorStatus = door.getDoorStatus();
        // 만약 문이 열려 있으면 우선 문을 닫음
        if (doorStatus == DoorStatus.OPENED) door.close();

        // LG 모터를 주어진 방향으로 이동시킴
        moveLGMotor(direction); // (이 부분을 제외하면 HyundaiMotor의 move 메서드와 동일)
        // 모터 상태를 이동 중으로 변경함
        setMotorStatus(MotorStatus.MOVING);
    }
}
