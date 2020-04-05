package com.factory.dao.impl;

import com.factory.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImp1 implements AccountDao {
    /**
     * 模拟实现保存账户操作
     */
    public void saveAccount() {
        System.out.println("用户保存了1111");
    }
}
