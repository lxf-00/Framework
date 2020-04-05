package com.springlearning.jdbcTemplate;

import com.springlearning.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * spring JdbcTemplate的CURD操作
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        // 1.获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 3. 保存操作
        // jt.update("insert into account(name,money)values(?,?)", "eee", 1000f);
        // 4. 更新操作
        // jt.update("update account set name=?, money=? where id=?", "update1", 2222f, 5);
        // 5. 删除操作
        // jt.update("delete from account where id=?", 5);
        // 6. 查询所有操作
        // List<Account> accounts = jt.query("select * from account where id > ?;", new AccountRowWrapper(), 3);
        /*List<Account> accounts = jt.query("select * from account where id > ?;", new BeanPropertyRowMapper<Account>(Account.class), 3);
        for (Account account : accounts) {
            System.out.println(account);
        }*/
        // 7. 查询一个
        /*List<Account> accounts = jt.query("select * from account where id = ?;", new BeanPropertyRowMapper<Account>(Account.class), 3);
        System.out.println(accounts.isEmpty() ? "没有此条数据":accounts.get(0));*/

        // 查询一行或一列（聚合函数）
        int count = jt.queryForObject("select count(*) from account where money > ?", Integer.class, 1000f);
        System.out.println(count);
    }

}

class AccountRowWrapper implements RowMapper<Account>{

    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}
