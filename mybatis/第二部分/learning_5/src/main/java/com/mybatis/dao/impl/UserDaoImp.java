package com.mybatis.dao.impl;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class UserDaoImp implements UserDao {
    private SqlSessionFactory factory;
    public UserDaoImp(SqlSessionFactory factory ){
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.mybatis.dao.UserDao.findAll");
        session.commit();
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.mybatis.dao.UserDao.saveUser");
        session.close();
    }

    public void updateUser(User user) {

    }

    public void delUser(Integer id) {

    }

    public User findById(Integer id) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
