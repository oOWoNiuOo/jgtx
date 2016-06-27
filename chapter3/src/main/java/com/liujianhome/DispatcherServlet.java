package com.liujianhome;


import com.liujianhome.bean.Data;
import com.liujianhome.bean.Handler;
import com.liujianhome.bean.Param;
import com.liujianhome.bean.View;
import com.liujianhome.helper.BeanHelper;
import com.liujianhome.helper.ConfigHelper;
import com.liujianhome.helper.ControllerHelper;
import com.liujianhome.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/27.
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 加载各个类
        HelperLoader.init();

        // 获取 ServletContext 对象（用于注册Servlet）
        ServletContext servletConfig = config.getServletContext();

        // 注册处理 JSP 的 Servlet
        ServletRegistration jspServlet = servletConfig.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

        // 注册处理静态资源的默认 Servlet
        ServletRegistration defaultServlet = servletConfig.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方法与请求路径
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();

        // 获取 Action 处理器
        Handler actionHandler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (actionHandler != null) {
            // 获取 Controller 类及其 Bean 实例
            Class<?> controllerClass = actionHandler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);

            // 创建请求参数对象
            Map<String, Object> paramMap = new HashMap<String, Object>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if (StringUtil.isNotEmpty(body)) {
                String[] params = StringUtil.splitString(body, "&");
                if (ArrayUtil.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] arrParam = StringUtil.splitString(param, "=");
                        if (ArrayUtil.isNotEmpty(arrParam) && arrParam.length == 2) {
                            String paramName = arrParam[0];
                            String paramValue = arrParam[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            // 调用 Action 方法
            Method method = actionHandler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean, method, param);

            // 处理 Action 方法返回值
            if (result instanceof View) {
                View view = (View) result;
                String path = view.getPath();
                if (StringUtil.isNotEmpty(path)) {
                    if (path.startsWith("/")) {
                        resp.sendRedirect(req.getContextPath() + path);
                    } else {
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> entry : model.entrySet()) {
                            req.setAttribute(entry.getKey(), entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
                    }
                }
            } else if (result instanceof Data) {
                Data data = (Data) result;
                Object model = data.getModel();
                if (model != null) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter pw = resp.getWriter();
                    String json = JsonUtil.toJSON(model);
                    pw.write(json);
                    pw.flush();
                    pw.close();
                }
            }
        }
    }
}
