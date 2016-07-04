package com.liujianhome.aop.demo7;

import com.liujianhome.proxy.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Dog dog = (Dog) context.getBean("dogAdvisorProxy");
        dog.say("Gread");

        dog.goodMorning("早上好!");

        dog.goodNight("晚上好");
    }

}
