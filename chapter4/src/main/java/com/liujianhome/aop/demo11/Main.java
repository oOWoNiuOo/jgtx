package com.liujianhome.aop.demo11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/8.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_demo11.xml");
        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.say("jianjian");

        Apology apology = (Apology) greeting;
        apology.saySorry("liuliu");
    }

}
