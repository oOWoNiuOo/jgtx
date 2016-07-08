package com.liujianhome.aop.demo9;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/6.
 */
@Component
public class T1 {

    public void sayHello(String name) {
        System.out.println("T1 hello " + name);
    }

}
