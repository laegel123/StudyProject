package com.example.designpattern.facade.example1.entity;

public class Amplifier {
    Tuner tuner;
    StreamingPlayer player;

    public void on() {

    }

    public void off() {

    }

    public void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }

    public void setPlayer(StreamingPlayer player) {
        this.player = player;
    }

    public void setStereoSound() {

    }

    public void setSurroundSound() {

    }

    public void setVolume() {

    }
}
