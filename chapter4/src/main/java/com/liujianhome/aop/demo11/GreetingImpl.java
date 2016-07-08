package com.liujianhome.aop.demo11;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/8.
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void say(String name) {
        System.out.println("Hello " + name);
    }
}
