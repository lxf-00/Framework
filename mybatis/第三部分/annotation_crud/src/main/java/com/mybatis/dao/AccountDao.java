package com.mybatis.dao;

import com.mybatis.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface AccountDao {
    /**
     * 查询所有账户信息
     * @return
     */
    @Select("select * from account;")
    @Results( id="accountMap",
            value={
                    @Result(id=true, column = "id", property = "id"),
                    @Result(column = "uid", property = "uid"),
                    @Result(column = "money", property = "money"),
                    @Result(column = "uid", property = "user", one=@One(select = "com.mybatis.dao.UserDao.findById", fetchType = FetchType.LAZY))
            }

    )
    List<Account> findAll();

    /**
     * 根据用户id,查询所属用户账号信息
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findByUid(Integer uid);
}
