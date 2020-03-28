package com.mybatis.test;

import com.mybatis.dao.AccountDao;
import com.mybatis.domain.Account;
import com.mybatis.domain.AccountUser;
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

public class AccountDaoTest {
    private InputStream is;
    private SqlSession session;
    private AccountDao accountDao;

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
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        // 提交事务
        session.commit();
        // 释放资源
        session.close();
        is.close();
    }

    /**
     * 查询所有账户功能测试
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
    }

}
