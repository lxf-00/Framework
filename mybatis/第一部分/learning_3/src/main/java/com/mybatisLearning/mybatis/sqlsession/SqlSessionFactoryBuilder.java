package com.mybatisLearning.mybatis.sqlsession;

import com.mybatisLearning.mybatis.cfg.Configuration;
import com.mybatisLearning.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.mybatisLearning.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 创建SqlSessionFactory 对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
