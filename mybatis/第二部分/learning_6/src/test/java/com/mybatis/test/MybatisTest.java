package com.mybatis.test;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的curd接口
 */
public class MybatisTest {
    private InputStream is;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        // 1，读取配置文件，生成字节流加载
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2, 获取SqlSessionFactory对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        // 3, 生成SqlSession对象
         session = factory.openSession();
        // 4, 生成dao代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        // 提交事务
        session.commit();
        // 释放资源
        session.close();
        is.close();
    }

    /**
     * 测试查询所有用户功能
     */
    @Test
    public void testFindAll() throws IOException {
        // 5,执行语句
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存用户功能
     */
    @Test
    public void testSaveUser() throws IOException {
        User user = new User();
        user.setUsername("saver-select");
        user.setAddress("重庆市");
        user.setSex("女");
        user.setBirthday(new Date());
        System.out.println("保存操作前的user:" + user);
        userDao.saveUser(user);
        System.out.println("保存操作后的user:" + user);
    }

    /**
     * 测试更新用户功能
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(50);
        user.setUsername("saver--mybatis");
        user.setAddress("广东省");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    /**
     * 测试删除用户功能
     */
    @Test
    public void testDelUser(){
        userDao.delUser(48);
    }

    /**
     * 测试根据id查询用户功能
     */
    @Test
    public void testFindById(){
        User byId = userDao.findById(50);
        System.out.println(byId);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询所有用户数
     */
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    /**
     * 测试根据多个自定义条件对象查询用户
     */
    @Test
    public void testFindByVo(){
        User u = new User();
        u.setUsername("%王%");
        QueryVo vo = new QueryVo();
        vo.setUser(u);

        List<User> byVo = userDao.findByVo(vo);
        for (User user : byVo) {
            System.out.println(user);
        }
    }

    /**
     * 测试动态sql语句：if
     */
    @Test
    public void testFindByUser(){
        User u = new User();
        u.setUsername("%王%");
        u.setSex("女");

        List<User> users = userDao.findByUser(u);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindByIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        list.add(44);

        vo.setIds(list);
        List<User> us = userDao.findByIds(vo);
        for (User u : us) {
            System.out.println(u);
        }
    }
}
