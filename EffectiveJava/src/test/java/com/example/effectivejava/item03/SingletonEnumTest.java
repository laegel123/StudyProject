package com.example.effectivejava.item03;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SingletonEnumTest {
    @Test
    void equals() {
        EnumTypeMember member = EnumTypeMember.INSTANCE;
        EnumTypeMember member2 = EnumTypeMember.INSTANCE;

        assertThat(member).isEqualTo(member2);
    }

    @Test
    void reflectionEquals() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumTypeMember member = EnumTypeMember.INSTANCE;

        // reflection API 를 이용한 객체 생성
        Class<?> classType = EnumTypeMember.class;
        Constructor<?>[] constructors = classType.getDeclaredConstructors();
        for(Constructor<?> constructor : constructors){
            constructor.setAccessible(true);
            EnumTypeMember member2 = (EnumTypeMember) constructor.newInstance("INSTANCE");

            assertThat(member).isEqualTo(member2);
        }
    }
}
