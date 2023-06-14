package com.example.designpattern.facade.example1.entity;

public class HomeTheaterFacade {
    Amplifier amplifier;
    Tuner tuner;
    StreamingPlayer player;
    Projector projector;
    TheaterLights theaterLights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amplifier, Tuner tuner, StreamingPlayer player, Projector projector, TheaterLights theaterLights, Screen screen, PopcornPopper popper) {
        this.amplifier = amplifier;
        this.tuner = tuner;
        this.player = player;
        this.projector = projector;
        this.theaterLights = theaterLights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie() {
        System.out.println("영화 볼 준비 중");
        popper.on();
        popper.pop();
        // ...
    }

    public void endMovie() {
        System.out.println("홈시어터를 끄는 중");
        popper.off();
        theaterLights.off();
        // ...
    }

    public void listenRadio() {

    }

    public void endRadio() {

    }
}
