package com.factory.ui;

import com.factory.factory_test.FactoryBean;
import com.factory.service.AccountService;

/**
 * 模拟表现层
 */
public class Client {
    public static void main(String[] args) {
        AccountService service = (AccountService)FactoryBean.createInstance("AccountService");
        service.saveAccount();
       /*AccountDao dao = (AccountDao)FactoryBean.createInstance("AccountDao");
       dao.saveAccount();*/
    }

}
