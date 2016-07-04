package com.liujianhome.aop.demo1;

import com.liujianhome.proxy.Dog;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Administrator on 2016/7/3.
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Dog());
        proxyFactory.addAdvice(new DogBeforeAdvice());
        proxyFactory.addAdvice(new DogAfterAdvice());

        Dog dog = (Dog) proxyFactory.getProxy();
        dog.say("加油");
    }

}
