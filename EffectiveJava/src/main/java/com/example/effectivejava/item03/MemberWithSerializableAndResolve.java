package com.example.effectivejava.item03;

import java.io.Serial;
import java.io.Serializable;

public class MemberWithSerializableAndResolve implements Serializable {
    private static MemberWithSerializableAndResolve member = new MemberWithSerializableAndResolve();
    transient String id = "";
    transient String name = "";
    transient int age = 0;
    private MemberWithSerializableAndResolve() {}

    public static MemberWithSerializableAndResolve getInstance() {
        return member;
    }

    @Serial
    private Object readResolve() {
        return member;
    }
}
