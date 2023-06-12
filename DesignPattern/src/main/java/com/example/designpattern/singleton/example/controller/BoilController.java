package com.example.designpattern.singleton.example.controller;

import com.example.designpattern.singleton.example.entity.ChocolateBoiler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoilController {

    @GetMapping("/boil")
    public ResponseEntity<String> boil() {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();

        return ResponseEntity.ok("test");
    }


}
