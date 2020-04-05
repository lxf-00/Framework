package com.ssm;

import com.springlearning.dao.AccountDao;
import com.springlearning.domain.Account;
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

public class ServiceTest {
    private AccountDao dao;
    private SqlSession session;
    private InputStream is;

    @Before
    public void init() throws Exception{
        // 加载配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 创建sqlsession对象
        session = factory.openSession();
        // 获取代理对象
        dao = session.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        // 事务提交
        session.commit();
        // 释放资源
        session.close();
        is.close();
    }

    @Test
    public void run1() throws Exception{
       // 调用查询方法
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void run2(){
        Account account = new Account();
        account.setName("王五");
        account.setMoney(1456d);
        dao.SaveAccount(account);
    }
}
