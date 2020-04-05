package com.springlearning.service.impl;

import com.springlearning.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl  implements AccountService {
    public void saveAccount() {

        System.out.println("执行了保存方法");
    }

    public void updateAccount(int id) {

        System.out.println("执行了保存方法");
    }

    public int deleteAccount() {
        System.out.println("执行了删除方法");
        return 0;
    }
}
