package com.liujianhome.cglib;

import com.liujianhome.demo1.Hello;
import com.liujianhome.demo1.HelloImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/7/1.
 */
public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy cgLibProxy;

    private CGLibProxy() {
    }

    public static CGLibProxy getInstance() {
        if (cgLibProxy == null) {
            cgLibProxy = new CGLibProxy();
        }
        return cgLibProxy;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void after() {
        System.out.println("说话完毕");
    }

    private void before() {
        System.out.println("开始说话");
    }

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    public static void main(String[] args) {
        Hello hello = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        hello.say("Jian Jian");
    }

}
