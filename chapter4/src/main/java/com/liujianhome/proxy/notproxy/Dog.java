package com.liujianhome.proxy.notproxy;

/**
 * Created by Administrator on 2016/7/1.
 */
public class Dog implements Animal {
    @Override
    public void say(String name) {
        before();
        System.out.println(name);
        after();
    }

    private void after() {
        System.out.println("说话完毕");
    }

    private void before() {
        System.out.println("开始说话");
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.say("汪汪汪");
    }
}
