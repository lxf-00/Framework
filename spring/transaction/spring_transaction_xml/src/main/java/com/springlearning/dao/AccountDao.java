package com.springlearning.dao;

import com.springlearning.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {
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

    /**
     * 根据账户名称查询账户
     * @return 如果有唯一账户，返回账户
     *         如果不存在，返回null
     *         如果结果集超过一个，抛出异常
     */
    Account findByName(String accountName);
}
