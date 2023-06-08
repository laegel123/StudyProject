package com.example.designpattern.factory.controller;

import com.example.designpattern.factory.entity.pizza.Pizza;
import com.example.designpattern.factory.entity.store.CalifoniaPizzaStore;
import com.example.designpattern.factory.entity.store.NYPizzaStore;
import com.example.designpattern.factory.entity.store.PizzaStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactoryController {

    @GetMapping("/factory")
    public ResponseEntity<String> factory() {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore calPizzaStore = new CalifoniaPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("첫 번째 주문한 " + pizza.getName());
        System.out.println();
        pizza = calPizzaStore.orderPizza("cheese");
        System.out.println("두 번째 주문한 " + pizza.getName());

        return ResponseEntity.ok("test");
    }

}
