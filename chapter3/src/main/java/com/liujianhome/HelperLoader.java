package com.liujianhome;

import com.liujianhome.helper.BeanHelper;
import com.liujianhome.helper.ClassHelper;
import com.liujianhome.helper.ControllerHelper;
import com.liujianhome.helper.IocHelper;
import com.liujianhome.util.ClassUtil;

/**
 * Created by Administrator on 2016/6/26.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classArr = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : classArr) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
