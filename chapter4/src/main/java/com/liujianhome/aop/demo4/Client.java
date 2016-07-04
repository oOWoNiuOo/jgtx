package com.liujianhome.aop.demo4;

import com.liujianhome.proxy.Animal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/3.
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Animal dog = (Animal) context.getBean("dogProxy");
        dog.say("你好，xml配置");
    }

}
