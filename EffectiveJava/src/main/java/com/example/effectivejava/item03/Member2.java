package com.example.effectivejava.item03;

public class Member2 {
    private static Member2 member2 = new Member2();
    public static Member2 getInstance() {
        return member2;
    }

    private Member2() {

    }
}
