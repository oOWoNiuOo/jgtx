package com.liujianhome;

import com.liujianhome.model.Customer;
import com.liujianhome.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CustomerService 单元测试
 * Created by Administrator on 2016/6/16.
 */
public class CustomerServiceTest {


    private CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void setUp() throws Exception {
        // TODO 初始化数据库
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList("");
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception {
        Customer customer = customerService.getCustomer(1);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer99");
        fieldMap.put("contact", "LJ");
        fieldMap.put("telephone", "18616228299");

        boolean result = customerService.createCustomer(fieldMap);

        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception {
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "updateName");

        boolean result = customerService.updateCustomer(1, fieldMap);

        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        boolean result = customerService.deleteCustomer(1);

        Assert.assertTrue(result);
    }


}
