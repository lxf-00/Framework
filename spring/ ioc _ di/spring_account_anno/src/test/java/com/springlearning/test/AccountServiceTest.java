package com.springlearning.test;

import com.springlearning.dao.AccountDao;
import com.springlearning.domain.Account;
import com.springlearning.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * 使用junit单元测试配置
 */
public class AccountServiceTest {
    private ApplicationContext ac;
    private AccountService as;

    @Before
    public void init(){
        //1, 获取核心容器
        ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        as  = ac.getBean("accountService", AccountService.class);
    }

    @Test
    public void testFindAllCount() {
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById(){
        Account account = as.findById(3);
        System.out.println(account);
    }

    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setName("张三");
        account.setMoney((float)3452);
        as.saveAccount(account);
    }
    @Test
    public void testUpdateAccount(){
        Account account = new Account();
        account.setName("张三");
        account.setMoney((float)3452);
        account.setId(4);
        as.updateAccount(account);
    }
    @Test
    public void testDeletAccount(){
        as.deleteAccount(4);
    }
}
