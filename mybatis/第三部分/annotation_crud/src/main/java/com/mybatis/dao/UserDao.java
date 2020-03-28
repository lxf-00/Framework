package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.junit.runners.Parameterized;

import java.util.List;

@CacheNamespace(blocking=true)//mybatis 基于注解方式实现配置二级缓存
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user;")
    @Results(
            id="userMap",
            value={
                    @Result(id = true, column = "id", property = "userId"),
                    @Result(column = "username", property = "userName"),
                    @Result(column = "address", property = "userAddress"),
                    @Result(column = "sex", property = "userSex"),
                    @Result(column = "birthday", property = "userBirthday"),
                    @Result(column = "id", property = "accounts", many=@Many(
                            select = "com.mybatis.dao.AccountDao.findByUid", fetchType = FetchType.LAZY
                    ))
            }
    )
    List<User> findAll();

    /**
     * 根据id查询用户
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findById(Integer id);

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username, address, sex, birthday) values(#{userName},#{userAddress},#{userSex},#{userBirthday})")
    @SelectKey(keyColumn = "id", keyProperty = "userId", resultType = Integer.class, before = false, statement = {"select last_insert_id();"})
    int saveUser(User user);

    /**
     * 更新操作
     * @param user
     * @return
     */
    @Update("update user set username=#{userName}, address=#{userAddress}, sex=#{userSex}, birthday=#{userBirthday} where id=#{userId};")
    int updateUser(User user);

    /**
     * 根据用户id，删除用户
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    int deleteUser(Integer id);

    /**
     * 聚合函数查询
     * @return
     */
    @Select("select count(*) from user;")
    int findTotal();

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{name};")
    @ResultMap("userMap")
    List<User> findByName(String name);
}
