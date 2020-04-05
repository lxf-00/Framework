package com.springlearning.dao;

import com.springlearning.domain.Account;

public interface AccountDao {
    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 根据账户名查询账户信息
     * @param accountName
     * @return
     */
    Account findByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
