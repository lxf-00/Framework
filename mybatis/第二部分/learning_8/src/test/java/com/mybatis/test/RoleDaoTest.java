package com.mybatis.test;

import com.mybatis.dao.RoleDao;
import com.mybatis.dao.UserDao;
import com.mybatis.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleDaoTest {
    private InputStream is;
    private SqlSession session;
    private RoleDao roleDao;

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
        roleDao = session.getMapper(RoleDao.class);
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
     * 查询所有角色信息，同时获取相对应的用户信息
     */
    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("每个角色的信息：");
            System.out.println(role);
        }
    }
}
