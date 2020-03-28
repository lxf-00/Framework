package com.mybatis.domain;

import java.io.Serializable;

/**
 * 账户实体类
 */
public class Account implements Serializable {
    /*
     ID    | int(11) | NO   | PRI | NULL    |       |
| UID   | int(11) | YES  | MUL | NULL    |       |
| MONEY | double  | YES  |     | NULL    |
     */
    private Integer id;
    private Integer uid;
    private Double money;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
