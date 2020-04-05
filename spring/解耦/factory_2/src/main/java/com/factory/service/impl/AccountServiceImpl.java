package com.factory.service.impl;

import com.factory.dao.AccountDao;
import com.factory.factory_test.FactoryBean;
import com.factory.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = (AccountDao)FactoryBean.createInstance("AccountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
