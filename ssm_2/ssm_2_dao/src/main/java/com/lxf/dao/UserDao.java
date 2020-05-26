package com.lxf.dao;

import com.lxf.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = java.util.List.class, many = @Many(select = "com.lxf.dao.RoleDao.findRoleByUserId")) })
    UserInfo findById(String id) throws Exception;


    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = java.util.List.class, many = @Many(select = "com.lxf.dao.RoleDao.findRoleByUserId")) })
    UserInfo findByUsername(String username);

    // 查询所有
    @Select("select * from users")
    List<UserInfo> findAll();

    // 保存用户
    @Insert("insert into users(username,email,password,phoneNum,status)values(#{username},#{email}," +
            "#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    // 用户添加角色
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
