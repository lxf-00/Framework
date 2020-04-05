package com.springlearning.dao.impl;

import com.springlearning.dao.AccountDao;
import com.springlearning.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccoungDaoImpl implements AccountDao {
    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public Account findById(Integer id) {
        List<Account> accounts = jt.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()? null:accounts.get(0);
    }

    public Account findByName(String accountName) {
        List<Account> accounts = jt.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size() > 1){
            throw new RuntimeException("数据不唯一。");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        jt.update("update account set name=?, money=? where id=?;", account.getName(), account.getMoney(),account.getId());
    }
}
