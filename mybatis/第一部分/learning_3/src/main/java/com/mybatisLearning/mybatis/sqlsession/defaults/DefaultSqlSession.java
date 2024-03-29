package com.mybatisLearning.mybatis.sqlsession.defaults;

import com.mybatisLearning.mybatis.cfg.Configuration;
import com.mybatisLearning.mybatis.sqlsession.SqlSession;
import com.mybatisLearning.mybatis.sqlsession.proxy.MapperProxy;
import com.mybatisLearning.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession的实现类
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection conn;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }
    /**
     * 创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
       return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
    }

    /**
     * 释放资源
     */
    public void close() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
