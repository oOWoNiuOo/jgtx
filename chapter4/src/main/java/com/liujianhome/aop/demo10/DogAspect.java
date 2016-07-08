package com.liujianhome.aop.demo10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/8.
 */
@Aspect
@Component
public class DogAspect {

    @Around("@annotation(com.liujianhome.aop.demo10.Tag)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        after();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        before();

        return result;
    }

    private void after() {
        System.out.println("前置通知");
    }

    private void before() {
        System.out.println("后置通知");
    }
}
