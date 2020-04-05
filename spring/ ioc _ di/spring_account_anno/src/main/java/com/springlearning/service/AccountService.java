package com.springlearning.service;

import com.springlearning.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id,查询特定账户
     * @return
     */
    Account findById(Integer id);

    /**
     * 保存账户
     */
    void saveAccount(Account account);

    /**
     * 更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除操作
     * @param id
     */
    void deleteAccount(Integer id);
}
