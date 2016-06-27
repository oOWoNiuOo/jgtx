package com.liujianhome.controller;

import com.liujianhome.model.Customer;
import com.liujianhome.service.CustomerService;

import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 进入 客户列表 界面
     *
     * @return
     */
    @Action("get:/customer")
    public View index() {
        List<Customer> customerList = customerService.getCustomerList("");
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    /**
     * 显示 客户基本信息
     *
     * @param param
     * @return
     */
    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    /**
     * 处理 创建客户请求
     *
     * @param param
     * @return
     */
    @Action("post:/customer_create")
    public Data create(Param param) {
        Map<String, Object> fieldMap = param.getMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    /**
     * 进入 编辑客户 界面
     *
     * @param param
     * @return
     */
    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    /**
     * 处理 编辑客户 请求
     *
     * @param param
     * @return
     */
    @Action("put:/customer_edit")
    public Data doEdit(Param param) {
        long id = param.getLong("id")
        Map<String, Object> fieldMap = param.getMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        new Data(result);
    }

    /**
     * 处理 删除客户 请求
     *
     * @param param
     * @return
     */
    @Action("delete:/customer_delete")
    public Data doDelete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        new Data(result);
    }

}
