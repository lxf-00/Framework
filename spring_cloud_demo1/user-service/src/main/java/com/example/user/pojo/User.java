package com.example.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer sex;  // 1 男性  2 女性
    private Date birthday;
    @Transient
    private String note;
    private Date created;
    private Date updated;
}
