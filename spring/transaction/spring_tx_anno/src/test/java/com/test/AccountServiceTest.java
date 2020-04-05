package com.test;


import com.springlearning.domain.Account;
import com.springlearning.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService as;
    @Test
    public void testFindById(){
        Account account = as.findById(1);
        System.out.println(account);
    }

    @Test
    public void testTransfer(){

        as.transfer("aaa", "bbb", 100f);
    }
}
