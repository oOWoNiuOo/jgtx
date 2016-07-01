package com.liujianhome.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/7/1.
 */
public class CGLibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void after() {
        System.out.println("说话完毕");
    }

    public <T> T getProxy(Class<?> cls) {
        return (T) Enhancer.create(cls, this);
    }

    private void before() {
        System.out.println("开始说话");
    }

    public static void main(String[] args) {
        SupDog supDog = new CGLibProxy().getProxy(SupDog.class);
        supDog.bigSay("汪汪汪");
    }
}
