package com.liujianhome.service;

import com.liujianhome.helper.DatabaseHelper;
import com.liujianhome.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 * Created by Administrator on 2016/6/16.
 */
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);


    /**
     * 获取客户列表
     *
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     *
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        return DatabaseHelper.queryEntity(Customer.class, id);
    }

    /**
     * 创建客户
     *
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     *
     * @param id
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     *
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
