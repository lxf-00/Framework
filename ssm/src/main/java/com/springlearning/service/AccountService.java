package com.springlearning.service;

import com.springlearning.domain.Account;

import java.util.List;

/**
 * 账户业务层接口类
 */
public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户
     * @param account
     */
    void SaveAccount(Account account);
}
