package com.mybatis.test;

import com.mybatis.dao.UserDao;
import com.mybatis.dao.impl.UserDaoImp;
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
        userDao = new UserDaoImp(factory);
        /*// 3, 生成SqlSession对象
        session = factory.openSession();
        // 4, 生成dao代理对象
        userDao = session.getMapper(UserDao.class);*/
    }

   /* @After
    public void destroy() throws IOException {
        // 提交事务
        session.commit();
        // 释放资源
        session.close();
        is.close();
    }
*/
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
        user.setUserName("save dao impl");
        user.setUserAddress("重庆市");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
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
        user.setUserId(50);
        user.setUserName("saver--mybatis");
        user.setUserAddress("广东省");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        userDao.updateUser(user);
    }

    /**
     * 测试根据id查询用户功能
     */
    @Test
    public void testFindById(){
        User byId = userDao.findById(50);
        System.out.println(byId);
    }
}
