package com.example.effectivejava.item03;

public enum EnumTypeMember {
    INSTANCE;
    private String name = "";

    public String getName() {
        return name;
    }
}
