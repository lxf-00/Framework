package com.factory.fac;

import com.factory.service.AccountService;
import com.factory.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static  AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
