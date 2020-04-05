package com.springlearning.service.impl;

import com.springlearning.dao.AccountDao;
import com.springlearning.domain.Account;
import com.springlearning.service.AccountService;
import com.springlearning.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findById(Integer id) {

        return accountDao.findById(id);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {

        accountDao.deleteAccount(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer........");
        // 2.1. 查询转出账户
        Account source = accountDao.findByName(sourceName);
        // 2.2. 查询转入账户
        Account target = accountDao.findByName(targetName);
        // 2.3. 转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 2.4. 转入账户加钱
        target.setMoney(target.getMoney() + money);

        // 2.5. 转入账户更新
        accountDao.updateAccount(source);
        int i = 1/0;
        // 2.6. 转出账户更新
        accountDao.updateAccount(target);
    }
}
