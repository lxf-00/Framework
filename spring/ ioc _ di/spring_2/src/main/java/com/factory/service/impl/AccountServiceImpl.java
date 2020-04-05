package com.factory.service.impl;


import com.factory.service.AccountService;

public class AccountServiceImpl implements AccountService {
    public AccountServiceImpl(){
        System.out.println("对象被创建了");
    }
    public void saveAccount() {
        System.out.println("service中的save方法执行了。。。。。");
    }

    public void init(){
        System.out.println("对象初始化了.....");
    }
    public void destroy(){
        System.out.println("对象销毁了....");
    }

}
