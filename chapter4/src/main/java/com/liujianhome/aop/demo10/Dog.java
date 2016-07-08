package com.liujianhome.aop.demo10;

/**
 * Created by Administrator on 2016/7/8.
 */
public class Dog implements Animal {

    @Tag
    @Override
    public void say(String name) {
        System.out.println("Hello " + name);
    }
}
