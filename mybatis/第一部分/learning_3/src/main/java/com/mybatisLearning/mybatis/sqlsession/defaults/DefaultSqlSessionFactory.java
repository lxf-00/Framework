package com.mybatisLearning.mybatis.sqlsession.defaults;

import com.mybatisLearning.mybatis.cfg.Configuration;
import com.mybatisLearning.mybatis.sqlsession.SqlSession;
import com.mybatisLearning.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory 接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 创建新的数据库连接对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
