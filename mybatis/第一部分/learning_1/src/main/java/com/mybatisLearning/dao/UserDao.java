package com.mybatisLearning.dao;

import com.mybatisLearning.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();
}
