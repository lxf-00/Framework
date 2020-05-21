package com.example.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User implements Serializable {
    /*
     id       | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| username | varchar(100) | YES  | UNI | NULL    |                |
| password | varchar(100) | YES  |     | NULL    |                |
| name     | varchar(100) | YES  |     | NULL    |                |
| age      | int(10)      | YES  |     | NULL    |                |
| sex      | tinyint(1)   | YES  |     | NULL    |                |
| birthday | date         | YES  |     | NULL    |                |
| note     | varchar(255) | YES  |     | NULL    |                |
| created  | datetime     | YES  |     | NULL    |                |
| updated  | datetime     | YES  |     | NULL
     */
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
