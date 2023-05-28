package com.example.springstudy.aop.notspringcode;

import com.example.springstudy.aop.entity.Exam;
import com.example.springstudy.aop.entity.ExamImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NotSpringAOPCode {

    public static void main(String[] args) {
        Exam exam = new ExamImpl(1, 1, 1, 1);

        Exam proxy = (Exam) Proxy.newProxyInstance(ExamImpl.class.getClassLoader(), new Class[]{Exam.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();

                        Object result = method.invoke(exam, args);

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        long end = System.currentTimeMillis();
                        String message = (end - start) + " 시간이 걸렸습니다.";
                        System.out.println(message);

                        return result;
                    }
                });

        System.out.println(proxy.total());
    }
}
