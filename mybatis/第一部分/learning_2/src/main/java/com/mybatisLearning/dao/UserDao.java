package com.mybatisLearning.dao;

import com.mybatisLearning.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user;")
    List<User> findAll();
}
