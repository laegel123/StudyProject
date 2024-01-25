package com.example.effectivejava.item03;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SingletonObjectTest {

    @Test
    void equals() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Member instance1 = Member.instance;

        // reflection API 를 이용한 객체 생성
        Class<?> classType = Member.class;
        Constructor<?> constructor = classType.getDeclaredConstructor();
        constructor.setAccessible(true);
        Member instance2 = (Member) constructor.newInstance();

        assertThat(instance1).isEqualTo(instance2);
    }

}
