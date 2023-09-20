package com.spring.pojo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class UserProxy {

    @Pointcut("execution(* com.spring.dao.impl.UserDaoImpl.*(..))")
    public void pointcut(){
    }

    //环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = null;
        System.out.println("环绕通知前...");
        long start = System.currentTimeMillis();
        proceed = proceedingJoinPoint.proceed();
        System.out.println("运行的方法= " + proceedingJoinPoint.getSignature().getName());
        System.out.println("方法参数= " + Arrays.toString(proceedingJoinPoint.getArgs()));
        long end = System.currentTimeMillis();
        System.out.println("运行时间= " + (end - start));
        System.out.println("环绕通知后...");
        return proceed;
    }
}
