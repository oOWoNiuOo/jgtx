package com.liujianhome.util;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by Administrator on 2016/6/26.
 */
public class ArrayUtil {

    /**
     * 判断数组是否非空
     *
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

}
