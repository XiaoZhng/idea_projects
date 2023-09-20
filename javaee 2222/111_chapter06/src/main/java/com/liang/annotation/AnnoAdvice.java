package com.liang.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnoAdvice {

    @Pointcut("execution( * com.liang.controller.*.*(..))")
    public void poincut1(){};

    @Before("poincut1()")
    public void before(JoinPoint joinPoint){
        System.out.println("增强开始");
    }
    @Around("poincut1()")
    public Object ar(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("开-----------");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("结束-------------");
        return proceed;
    }

    @After("poincut1()")
    public void af(JoinPoint joinPoint){
        System.out.println("增强结束");
    }
}
