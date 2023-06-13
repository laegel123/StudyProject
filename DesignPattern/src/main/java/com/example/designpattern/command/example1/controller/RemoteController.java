package com.example.designpattern.command.example1.controller;

import com.example.designpattern.command.example1.entity.behavior.GarageDoor;
import com.example.designpattern.command.example1.entity.behavior.Light;
import com.example.designpattern.command.example1.entity.command.Command;
import com.example.designpattern.command.example1.entity.command.GarageDoorOpenCommand;
import com.example.designpattern.command.example1.entity.command.LightOnCommand;
import com.example.designpattern.command.example1.entity.control.SimpleRemoteControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteController {

    @GetMapping("/remote")
    public ResponseEntity<String> remote() {
        SimpleRemoteControl control = new SimpleRemoteControl();

        Command ligthCommand = new LightOnCommand(new Light());
        Command garageDoorCommand = new GarageDoorOpenCommand(new GarageDoor());

        control.setCommand(ligthCommand);
        control.buttonWasPressed();

        control.setCommand(garageDoorCommand);
        control.buttonWasPressed();

        return ResponseEntity.ok("test");
    }
}
