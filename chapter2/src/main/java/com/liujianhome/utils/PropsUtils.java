package com.liujianhome.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/17.
 */
public class PropsUtils {
    private static final Logger logger = LoggerFactory.getLogger(PropsUtils.class);

    /**
     * 加载属性文件
     *
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName) {
        Properties properties = null;
        InputStream is = null;
        logger.info(Thread.currentThread().getName() + "-加载配置");
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + " 文件未找到");
            }
            properties = new Properties();
            properties.load(is);
        } catch (FileNotFoundException e) {
            logger.error(fileName + "文件没找到");
        } catch (IOException e) {
            logger.error("加载properties失败", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("关闭流失败", e);
                }
            }
        }
        return null;
    }

    /**
     * 获取字符类型属性(可以指定默认值)
     *
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 获取字符型属性(默认值为空字符)
     *
     * @param properties
     * @param key
     * @return
     */
    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }

    /**
     * 获取数值型属性（默认为0）
     *
     * @param properties
     * @param key
     * @return
     */
    public static int getInt(Properties properties, String key) {
        return getInt(properties, key, 0);
    }

    /**
     * 获取数值型属性（可指定默认值）
     *
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties properties, String key, int defaultValue) {
        int value = defaultValue;
        if (properties.containsKey(key)) {
            // TODO
//            value = CaseUtil.caseInt(properties.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型的值（可指定默认值）
     *
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Properties properties, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (properties.containsKey(key)) {
            value = CaseUtil.caseBoolean(properties.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型的值（默认值false）
     *
     * @param properties
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties properties, String key) {
        return getBoolean(properties, key, false);
    }
//    public static String getString(Properties properties, String key) {
//        return get
//    }


}
