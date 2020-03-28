package com.mybatis.dao;

import com.mybatis.domain.Role;

import java.util.List;

/**
 * Role 持久层接口类
 */
public interface RoleDao {
    /**
     * 查询所有角色信息
     * @return
     */
    List<Role> findAll();
}
