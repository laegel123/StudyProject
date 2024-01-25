package com.example.effectivejava.item03;

import java.io.Serializable;

public class MemberWithSerializable implements Serializable {
    private static MemberWithSerializable member = new MemberWithSerializable();
    private MemberWithSerializable() {}

    public static MemberWithSerializable getInstance() {
        return member;
    }
}
