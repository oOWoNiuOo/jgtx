package com.liujianhome.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/27.
 */
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 将 POJO 转为 JSON
     *
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> String toJSON(T bean) {
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(bean);
        } catch (IOException e) {
            LOGGER.error("转Json失败!", e);
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * 将 JSON 转为 POJO
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T parseJSON(String json, Class<T> type) {
        T jsonObj;
        try {
            jsonObj = OBJECT_MAPPER.readValue(json, type);
        } catch (IOException e) {
            LOGGER.error("转对象失败!", e);
            throw new RuntimeException(e);
        }
        return jsonObj;
    }
}
