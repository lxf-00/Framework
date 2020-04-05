package com.factory.service.impl;


import com.factory.service.AccountService;

import java.util.*;

public class AccountServiceImpl2 implements AccountService {
    private String[] myarray;
    private List<String> mylist;
    private Set<String> myset;
    private Map<String, String> mymap;

    public void setMyarray(String[] myarray) {
        this.myarray = myarray;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public void setMyset(Set<String> myset) {
        this.myset = myset;
    }

    public void setMymap(Map<String, String> mymap) {
        this.mymap = mymap;
    }

    public void saveAccount() {
        System.out.println(myarray);
        System.out.println(mylist);
        System.out.println(myset);
        System.out.println(mymap);
    }
}
