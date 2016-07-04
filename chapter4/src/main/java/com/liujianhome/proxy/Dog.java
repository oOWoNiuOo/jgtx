package com.liujianhome.proxy;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/1.
 */
@Component
public class Dog implements Animal {
    @Override
    public void say(String name) {
        System.out.println(name);
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning! " + name);
    }

    public void goodNight(String name) {
        System.out.println("Good Night! " + name);
    }

}
