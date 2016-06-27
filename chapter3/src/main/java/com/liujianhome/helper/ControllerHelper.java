package com.liujianhome.helper;

import com.liujianhome.annotation.Action;
import com.liujianhome.bean.Handler;
import com.liujianhome.bean.Request;
import com.liujianhome.util.CollectionUtil;
import org.smart4j.framework.util.ArrayUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/26.
 */
public class ControllerHelper {
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        // 获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            // 遍历Controller类
            for (Class<?> cls : controllerClassSet) {
                // 得到该类下所有公共的方法
                Method[] methods = cls.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    // 遍历方法
                    for (Method method : methods) {
                        // 判断是否有annotation为action的方法
                        if (method.isAnnotationPresent(Action.class)) {
                            // 得到Action
                            Action action = method.getAnnotation(Action.class);
                            // 得到Action中的值
                            String mapping = action.value();
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    String requstMehtod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requstMehtod, requestPath);
                                    Handler handler = new Handler(cls, method);
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取 Handler
     *
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
