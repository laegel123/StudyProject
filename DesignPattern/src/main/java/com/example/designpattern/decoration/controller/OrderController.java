package com.example.designpattern.decoration.controller;

import com.example.designpattern.decoration.entity.Beverage;
import com.example.designpattern.decoration.entity.coffee.DarkRoast;
import com.example.designpattern.decoration.entity.coffee.Espresso;
import com.example.designpattern.decoration.entity.decorate.Mocha;
import com.example.designpattern.decoration.entity.decorate.Whip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order")
    public ResponseEntity<String> order() {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2.setSize(Beverage.Size.VENTI);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());


        return ResponseEntity.ok("test");
    }
}
