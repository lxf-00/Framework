package com.mybatis.dao;

import com.mybatis.domain.QueryVo;
import com.mybatis.domain.User;

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

    /**
     * 增加用户（保存用户）
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void delUser(Integer id);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 模糊查询用户
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询用户总数
     * @return
     */
    int findTotal();

    /**
     * 根据QueryVo 对象查询用户
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);

    /**
     * 根据用户查询数据库
     * @param user
     * @return
     */
    List<User> findByUser(User user);

    /**
     * 根据传入的用户id数组进行查询
     * @param vo
     * @return
     */
    List<User> findByIds(QueryVo vo);
}
