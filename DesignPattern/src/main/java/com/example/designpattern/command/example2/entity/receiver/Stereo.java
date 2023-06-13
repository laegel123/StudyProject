package com.example.designpattern.command.example2.entity.receiver;

public class Stereo {
    String position;

    public Stereo(String position) {
        this.position = position;
    }

    public void on() {
        System.out.println(position + " 오디오가 켜졌습니다.");
    }

    public void setCD() {
        System.out.println(position + " 오디오 CD가 삽입되었습니다.");
    }

    public void off() {
        System.out.println(position + " 오디오가 꺼졌습니다.");
    }
}
