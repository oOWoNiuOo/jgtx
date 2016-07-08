package com.liujianhome.aop.demo9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectJ.xml");

        T1 t = (T1) context.getBean("t1");
        t.sayHello("xxx");
    }
}
