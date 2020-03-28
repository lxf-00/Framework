package com.mybatis.dao;

import com.mybatis.domain.Account;
import com.mybatis.domain.AccountUser;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface AccountDao {
    /**
     * 查询所有账户，同时获取账户所属用户和地址信息
     * @return
     */
//    List<AccountUser> findAll();
    List<Account> findAll();
}
