package com.factory.service.impl;


import com.factory.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {
    // 经常变化的数据，并不适用于注入方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {

        System.out.println("service中的save方法执行了。。。。。" + name + "," + age + "," + birthday);
    }
}
