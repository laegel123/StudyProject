package com.example.designpattern.factory.entity.pizza;

public class NYCheesePizza extends Pizza {

    public NYCheesePizza() {
        name = "뉴욕 스타일 치즈 피자";
        dough = "씬 크러스트 도우";
        sauce = "마리나라 소스";

        toppings.add("잘게 썬 레지아노 치즈");
    }
}
