package com.springlearning.service;

/**
 * 模拟业务层接口
 */
public interface AccountService {
    /**
     *模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟保存用户
     * @param id
     */
    void updateAccount(int id);

    /**
     * 模拟删除用户
     * @return
     */
    int deleteAccount();
}
