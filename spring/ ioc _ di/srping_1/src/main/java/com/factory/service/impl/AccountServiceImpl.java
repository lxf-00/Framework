package com.factory.service.impl;

import com.factory.dao.AccountDao;
import com.factory.dao.impl.AccountDaoImp;
import com.factory.service.AccountService;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImp();
    public AccountServiceImpl(){
        System.out.println("对象被创建了");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
