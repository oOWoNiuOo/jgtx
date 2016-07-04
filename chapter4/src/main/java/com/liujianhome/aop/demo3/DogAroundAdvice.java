package com.liujianhome.aop.demo3;

import com.liujianhome.proxy.Dog;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/3.
 */
@Component
public class DogAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("说话完毕");
    }

    private void before() {
        System.out.println("开始说话");
    }

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Dog());
        proxyFactory.addAdvice(new DogAroundAdvice());

        Dog dog = (Dog) proxyFactory.getProxy();
        dog.say("你好，环绕通知~");
    }

}
