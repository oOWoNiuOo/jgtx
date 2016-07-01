package com.liujianhome.proxy.dynamicproxy;

import com.liujianhome.proxy.Animal;
import com.liujianhome.proxy.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/7/1.
 */
public class DynamicProxy implements InvocationHandler {

    Object tagget;

    public DynamicProxy(Object tagget) {
        this.tagget = tagget;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(tagget.getClass().getClassLoader(),
                tagget.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(tagget, args);
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

        DynamicProxy dynamicProxy = new DynamicProxy(new Dog());
        Animal dog = dynamicProxy.getProxy();

        dog.say("汪汪汪");

    }
}
