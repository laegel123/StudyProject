package com.example.designpattern.singleton.example2.controller;

import com.example.designpattern.singleton.example2.entity.ChocolateBoiler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoilController {

    @GetMapping("/boil2")
    public ResponseEntity<String> boil2() {
        ChocolateBoiler boiler = ChocolateBoiler.INSTANCE;

        boiler.fill();

        return ResponseEntity.ok("Test");
    }
}
