package com.example.effectivejava.item03;

public class Member {
    public static final Member instance = new Member();
    private Member() {
        if (instance != null) {
            throw new UnsupportedOperationException("can't be created by constructor.");
        }
    }
}
