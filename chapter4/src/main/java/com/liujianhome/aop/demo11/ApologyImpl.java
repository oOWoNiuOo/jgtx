package com.liujianhome.aop.demo11;

/**
 * Created by Administrator on 2016/7/8.
 */
public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}
