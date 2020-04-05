package com.springlearning.service.impl;

import com.springlearning.service.AccountService;

public class AccountServiceImpl  implements AccountService {
    public void saveAccount() {
        System.out.println("执行力保存方法");
    }

    public void updateAccount(int id) {
        System.out.println("执行力保存方法");
    }

    public int deleteAccount() {
        System.out.println("执行了删除方法");
        return 0;
    }
}
