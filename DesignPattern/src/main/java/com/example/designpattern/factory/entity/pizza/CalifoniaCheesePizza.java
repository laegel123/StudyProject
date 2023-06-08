package com.example.designpattern.factory.entity.pizza;

public class CalifoniaCheesePizza extends Pizza {

    public CalifoniaCheesePizza() {
        name = "캘리포니아 스타일 치즈 피자";
        dough = "아주 두꺼운 크러스트 도우";
        sauce = "플럼토마토 소스";

        toppings.add("잘게 조각낸 모짜렐라 치즈");
    }

    @Override
    public void cut() {
        System.out.println("네모난 모양으로 피자 자르기");
    }
}
