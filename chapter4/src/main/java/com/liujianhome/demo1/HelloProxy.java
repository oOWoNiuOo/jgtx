package com.liujianhome.demo1;

/**
 * Created by Administrator on 2016/6/30.
 */
public class HelloProxy implements Hello {

    Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }


    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void after() {
        System.out.println("说话完毕");
    }

    private void before() {
        System.out.println("开始说话");
    }

    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy();
        helloProxy.say("Gread");
    }
}
