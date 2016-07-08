package com.liujianhome.aop.demo8_e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        TestImpl test = (TestImpl) context.getBean("autoProxyClass");
        test.sayHelloTest("Test");
    }

}
