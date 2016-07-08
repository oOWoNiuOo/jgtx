package com.liujianhome.aop.demo8_e;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test2Impl implements ITest2 {
    @Override
    public void sayHelloTest2(String name) {
        System.out.println("hello Test2 : " + name);
    }
}
