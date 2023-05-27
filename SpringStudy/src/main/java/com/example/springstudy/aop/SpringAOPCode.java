package com.example.springstudy.aop;

import com.example.springstudy.aop.advice.LogAroundAdvice;
import com.example.springstudy.aop.entity.Exam;
import com.example.springstudy.aop.entity.ExamImpl;
import org.springframework.aop.framework.ProxyFactory;

public class SpringAOPCode {
    public static void main(String[] args) {
        Exam target = new ExamImpl(1, 1, 1, 1);
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new LogAroundAdvice());

        Exam exam = (Exam) proxyFactory.getProxy();

        exam.total();
    }
}
