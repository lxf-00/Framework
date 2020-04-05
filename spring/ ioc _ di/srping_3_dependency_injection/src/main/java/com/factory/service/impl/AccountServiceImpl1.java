package com.factory.service.impl;


import com.factory.service.AccountService;

import java.util.Date;

public class AccountServiceImpl1 implements AccountService {
    // 经常变化的数据，并不适用于注入方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的save方法执行了。。。。。" + name + "," + age + "," + birthday);
    }
}
