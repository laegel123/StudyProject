package com.example.designpattern.strategy.controller;

import com.example.designpattern.strategy.entity.Duck;
import com.example.designpattern.strategy.entity.MallarDuck;
import com.example.designpattern.strategy.entity.ModelDuck;
import com.example.designpattern.strategy.entity.fly.FlyRocketPowered;
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
