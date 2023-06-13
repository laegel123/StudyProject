package com.example.designpattern.command.example2.entity.command;

import com.example.designpattern.command.example2.entity.receiver.Stereo;

public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
