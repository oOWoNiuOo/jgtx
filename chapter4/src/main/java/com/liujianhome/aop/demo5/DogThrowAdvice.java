package com.liujianhome.aop.demo5;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/7/3.
 */
public class DogThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) throws Throwable {
        System.out.println("============== Throw Exception ==============");
        System.out.println("Target Class: " + target.getClass().getName());
        System.out.println("Method Name: " + method.getName());
        System.out.println("Exception Message: " + e.getMessage());
        System.out.println("=============================================");
    }

}
