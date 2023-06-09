package com.example.designpattern.command.example2.controller;

import com.example.designpattern.command.example2.entity.command.*;
import com.example.designpattern.command.example2.entity.invoker.RemoteControl;
import com.example.designpattern.command.example2.entity.receiver.Light;
import com.example.designpattern.command.example2.entity.receiver.Stereo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteController2 {

    @GetMapping("/remote2")
    public ResponseEntity<String> remote2() {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Stereo stereo = new Stereo("Living Room");

        remoteControl.setCommand(0, new LightOnCommand(livingRoomLight), new LightOffCommand(livingRoomLight));
        remoteControl.setCommand(1, new StereoOnWithCDCommand(stereo), new StereoOffCommand(stereo));
        remoteControl.setCommand(2, new LightOnCommand(kitchenLight), new LightOffCommand(kitchenLight));

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();

        System.out.println("-------macro command-------");
        Command livingRoomLightOnCommand = new LightOnCommand(new Light("Living Room"));
        Command kitchenLightOnLight = new LightOnCommand(new Light("Kitchen"));
        Command stereoOnCommand = new StereoOnWithCDCommand(new Stereo("Living Room"));
        Command livingRoomLightOffCommand = new LightOffCommand(new Light("Living Room"));
        Command kitchenLightOffLight = new LightOffCommand(new Light("Kitchen"));
        Command stereoOffCommand = new StereoOffCommand(new Stereo("Living Room"));

        Command[] macroOnCommands = {livingRoomLightOnCommand, kitchenLightOnLight, stereoOnCommand};
        Command[] macroOffCommands = {livingRoomLightOffCommand, kitchenLightOffLight, stereoOffCommand};
        remoteControl.setCommand(3, new MacroCommand(macroOnCommands), new MacroCommand(macroOffCommands));

        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);


        return ResponseEntity.ok("Test");
    }
}
