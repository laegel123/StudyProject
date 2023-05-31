package com.example.designpattern.duck.controller;

import com.example.designpattern.duck.entity.Duck;
import com.example.designpattern.duck.entity.MallarDuck;
import com.example.designpattern.duck.entity.ModelDuck;
import com.example.designpattern.duck.entity.fly.FlyRocketPowered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DuckController {

    @GetMapping("/mallardduck")
    public ResponseEntity<String> mallardduck() {
        Duck mallard = new MallarDuck();

        mallard.performFly();
        mallard.performQuack();

        return ResponseEntity.ok("test");
    }

    @GetMapping("/miniduck")
    public ResponseEntity<String> miniduck() {
        Duck model = new ModelDuck();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        return ResponseEntity.ok("test");
    }
}
