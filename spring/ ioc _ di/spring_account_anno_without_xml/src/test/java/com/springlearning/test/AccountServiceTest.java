package com.springlearning.test;

import config.SpringConfig;
import com.springlearning.domain.Account;
import com.springlearning.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private AccountService as;

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
