package com.springlearning.service;

import com.springlearning.domain.Account;

/**
 * 账户业务层接口
 */
public interface AccountService {
    /**
     * 根据用户id查询账户
     * @param id
     * @return
     */
    Account findById(Integer id);

    void transfer(String sourceName, String targetName, Float money);
}
