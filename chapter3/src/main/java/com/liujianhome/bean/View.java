package com.liujianhome.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回视图对象
 * Created by Administrator on 2016/6/26.
 */
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String, Object> model = new HashMap<String, Object>();

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    /**
     * 添加模型数据
     *
     * @param key
     * @param value
     * @return
     */
    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
