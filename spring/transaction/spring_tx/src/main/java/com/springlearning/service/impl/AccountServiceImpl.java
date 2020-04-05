package com.springlearning.service.impl;

import com.springlearning.dao.AccountDao;
import com.springlearning.domain.Account;
import com.springlearning.service.AccountService;

public class AccountServiceImpl  implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findById(Integer id) {
       return accountDao.findById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        // 1. 查询转出账户
        Account source = accountDao.findByName(sourceName);
        // 2. 查询转入账户
        Account target = accountDao.findByName(targetName);
        // 3. 转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 4. 转入账户加钱
        target.setMoney(target.getMoney() + money);
        // 5. 更新转出账户
        accountDao.updateAccount(source);
        // 6. 更新转入账户
        accountDao.updateAccount(target);
    }
}
