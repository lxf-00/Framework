package com.springlearning.jdbcTemplate;

import com.springlearning.dao.AccountDao;
import com.springlearning.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * spring JdbcTemplate的基本用法
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        // 1.获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        // 3. 执行操作
        /*Account account1 = accountDao.findById(3);
        System.out.println(account1);*/

        /*Account ddd = accountDao.findByName("ddd");
        System.out.println(ddd);*/
        Account account = new Account();
        account.setName("李四");
        account.setMoney(2343f);
        account.setId(3);
        accountDao.updateAccount(account);

    }
}
