package com.springlearning.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * spring JdbcTemplate的基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 1 准备数据源对象：spring内置数据源对象
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://172.16.36.164:3306/spring_1");
        ds.setUsername("root");
        ds.setPassword("123456");
        // 2. 创建Template对象那个
        JdbcTemplate jt = new JdbcTemplate(ds);
        // 3. 执行插入操作
        jt.execute("insert into account(name, money)values('ccc',1000f)");
    }
}
