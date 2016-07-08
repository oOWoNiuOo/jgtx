package com.liujianhome.aop.demo9;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/6.
 */
@Aspect
@Component
public class DogAspect {

    @Around("execution(* com.liujianhome.aop.demo9.T1.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("前置通知");
    }

    private void before() {
        System.out.println("后置通知");
    }


}
