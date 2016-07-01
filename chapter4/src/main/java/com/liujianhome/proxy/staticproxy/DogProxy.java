package com.liujianhome.proxy.staticproxy;

import com.liujianhome.proxy.Animal;
import com.liujianhome.proxy.Dog;

/**
 * Created by Administrator on 2016/7/1.
 */
public class DogProxy implements Animal {

    private Dog dog;

    public DogProxy(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void say(String name) {
        before();
        dog.say(name);
        after();
    }

    private void after() {
        System.out.println("说话完毕");
    }

    private void before() {
        System.out.println("开始说话");
    }

    public static void main(String[] args) {
        DogProxy dogProxy = new DogProxy(new Dog());
        dogProxy.say("汪汪汪");
    }
}
