package com.liujianhome.proxy;

/**
 * Created by Administrator on 2016/7/1.
 */
public class Dog implements Animal {
    @Override
    public void say(String name) {
        System.out.println(name);
    }
}
