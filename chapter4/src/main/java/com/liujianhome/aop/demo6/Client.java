package com.liujianhome.aop.demo6;

import com.liujianhome.proxy.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Dog dog = (Dog) context.getBean("dogIntroProxy");
        dog.say("Gread");

        Apology apology = (Apology) dog;
        apology.saySorry("Gread");

    }

}
