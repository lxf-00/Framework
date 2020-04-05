package com.springlearning.service.impl;

import com.springlearning.dao.AccountDao;
import com.springlearning.domain.Account;
import com.springlearning.service.AccountService;
import com.springlearning.utils.TransactionManager;

import java.util.List;

/**
 * 账户业务层实现类
 */

public class AccountServiceImplOLD implements AccountService {
    private AccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(AccountDao accountDao) {

        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try{
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return accounts;
        }catch (Exception e){
            // 5. 回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    public Account findById(Integer id) {
        try{
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            Account account = accountDao.findById(id);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return account;
        }catch (Exception e){
            // 5. 回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.saveAccount(account);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        }catch (Exception e){
            // 5. 回滚事务
            txManager.rollback();
        }finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.updateAccount(account);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        }catch (Exception e){
            // 5. 回滚事务
            txManager.rollback();
        }finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    public void deleteAccount(Integer id) {
        try{
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.deleteAccount(id);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        }catch (Exception e){
            // 5. 回滚事务
            txManager.rollback();
        }finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try{
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
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
//            int i = 1/0;
            // 2.6. 转出账户更新
            accountDao.updateAccount(target);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        }catch (Exception e){
            // 5. 回滚事务
            txManager.rollback();
            e.printStackTrace();
        }finally {
            // 6. 释放连接
            txManager.release();
        }

    }
}
