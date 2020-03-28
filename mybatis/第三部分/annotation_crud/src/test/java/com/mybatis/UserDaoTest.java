package com.mybatis;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    private SqlSession session;
    private InputStream is;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        is.close();
        session.close();
    }

    /**
     * 查询所有的用户功能
     * 注解方式
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 根据id查询用户
     * 注解方式
     */
    @Test
    public void testFindById(){
        User ui = userDao.findById(41);
        System.out.println(ui);
    }

    /**
     * 保存用户
     * 注解方式
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUserName("张三");
        user.setUserBirthday(new Date());
        user.setUserAddress("上海");
        user.setUserSex("男");

        int i = userDao.saveUser(user);
    }

    /**
     * 更新用户
     * 注解方式
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUserName("李四");
        user.setUserBirthday(new Date());
        user.setUserAddress("北京");
        user.setUserSex("女");
        user.setUserId(59);

        userDao.updateUser(user);
    }

    /**
     * 根据id,删除用户
     * 注解方式
     */
    @Test
    public void testDeleteUser(){
        int i = userDao.deleteUser(59);
    }

    /**
     * 聚合函数查询
     * 注解方式
     */
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println("总记录数：" + total);
    }

    @Test
    public void testFindByName(){
        String name = "%王%";
        List<User> users = userDao.findByName(name);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
