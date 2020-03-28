package com.mybatisLearning.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /*id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| username | varchar(32)  | NO   |     | NULL    |                |
| birthday | datetime     | YES  |     | NULL    |                |
| sex      | char(1)      | YES  |     | NULL    |                |
| address  | varchar(256) | YES  |     | NULL    | */
    private Integer id;   // 用户编号
    private String username; // 用户姓名
    private Date birthday; // 出生年月日
    private String sex; // 性别
    private String address; // 地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
