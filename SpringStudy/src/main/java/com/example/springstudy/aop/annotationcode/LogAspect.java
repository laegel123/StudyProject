package com.example.springstudy.aop.annotationcode;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogGetDate)") // method 실행 되는 전 과정
    public Object LogGetDate(ProceedingJoinPoint point) throws Throwable {
        //해당 클래스 처리 전의 시간
        StopWatch sw = new StopWatch();
        sw.start();

        //해당하는 클래스의 메소드 핵심기능을 실행
        Object result = point.proceed();

        //해당 클래스 처리 후의 시간
        sw.stop();
        long executionTime = sw.getTotalTimeMillis();

        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        String task = className + ". " + methodName;

        logger.info("[ExecutionTime] " + task + "-->" + executionTime + "(ms)");

        return result;
    }
}
