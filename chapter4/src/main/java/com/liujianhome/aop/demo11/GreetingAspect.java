package com.liujianhome.aop.demo11;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/8.
 */
@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value = "com.liujianhome.aop.demo11.GreetingImpl",
            defaultImpl = ApologyImpl.class)
    private Apology Apology;
}
