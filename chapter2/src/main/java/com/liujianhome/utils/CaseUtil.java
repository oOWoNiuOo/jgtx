package com.liujianhome.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/17.
 */
public class CaseUtil {
    public static void main(String[] args) {

    }

    public static final Logger log = LoggerFactory.getLogger(CaseUtil.class);

    /**
     * 转换字符串型（可指定默认值）
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String caseString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转换字符串型（默认值空字符）
     *
     * @param obj
     * @return
     */
    public static String caseString(Object obj) {
        return caseString(obj, "");
    }

    /**
     * 转换布尔型（可指定默认值）
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean caseBoolean(Object obj, boolean defaultValue) {
        boolean value = defaultValue;
        if (obj != null) {
            value = Boolean.parseBoolean(caseString(obj));
        }
        return value;
    }


    /**
     * 转换布尔型
     *
     * @param obj
     * @return
     */
    public static boolean caseBoolean(Object obj) {
        return caseBoolean(obj, false);
    }

    /**
     * 转换数值型（可指定默认值）
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int caseInt(Object obj, int defaultValue) {
        int value = defaultValue;
        if (obj != null) {
            String valueStr = caseString(obj);
            if (StringUtil.isNotEmpty(valueStr)) {
                try {
                    value = Integer.parseInt(valueStr);
                } catch (NumberFormatException e) {
                    log.error("转换int类型失败，被转字符串：" + valueStr, e);
                }
            }

        }
        return value;
    }

    /**
     * 数值型转换
     *
     * @param obj
     * @return
     */
    public static int caseInt(Object obj) {
        return caseInt(obj, 0);
    }
}
