package com.springlearning.controller;

import com.springlearning.domain.Account;
import com.springlearning.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String testFindAll(){
        System.out.println("表现层：查询所有的账户");
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        return "list";
    }

    @RequestMapping("/save")
    public String testSaveAccount(Account account){
        accountService.SaveAccount(account);
        return "list";
    }
}
