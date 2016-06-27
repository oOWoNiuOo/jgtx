package com.liujianhome.helper;

import com.liujianhome.annotation.Inject;
import com.liujianhome.util.ArrayUtil;
import com.liujianhome.util.CollectionUtil;
import com.liujianhome.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/26.
 */
public final class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntity : beanMap.entrySet()) {
                // 从 BeanMap 中获取 Bean 类与 com.liujianhome.bean 实例
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                // 获取 Bean 类定义的所有成员变量(简称：Bean Field)
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    // 遍历 Bean Field
                    for (Field beanField : beanFields) {
                        // 判断当前 Bean Field 是否带有 Inject 注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = BeanHelper.getBean(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
