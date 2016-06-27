package com.liujianhome.bean;

import com.liujianhome.util.CaseUtil;

import java.util.Map;

/**
 * Created by Administrator on 2016/6/26.
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取 long 型参数值
     *
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CaseUtil.caseLong(paramMap.get(name));
    }

    /**
     * 根据参数名获取 字符串 型参数值
     *
     * @param name
     * @return
     */
    public String getString(String name) {
        return CaseUtil.caseString(paramMap.get(name));
    }

    /**
     * 获取所有的字段信息
     *
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
