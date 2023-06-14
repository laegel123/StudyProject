package com.example.designpattern.adapter.example1.controller;

import com.example.designpattern.adapter.example1.adapter.TurkeyAdapter;
import com.example.designpattern.adapter.example1.entity.Duck;
import com.example.designpattern.adapter.example1.entity.Turkey;
import com.example.designpattern.adapter.example1.entity.WildTurkey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdapterController {

    @GetMapping("/adapter")
    public ResponseEntity<String> adapter() {
        Turkey wildTurkey = new WildTurkey();

        Duck turkeyDuck = new TurkeyAdapter(wildTurkey);

        System.out.println("Duck Interface 로 실행되는 칠면조");
        turkeyDuck.quack();
        turkeyDuck.fly();

        return ResponseEntity.ok("Test");
    }
}
