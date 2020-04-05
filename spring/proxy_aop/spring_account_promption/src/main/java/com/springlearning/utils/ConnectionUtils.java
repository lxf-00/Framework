package com.springlearning.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类： 实现从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        // 1. 先从ThreadLocal中获取
        Connection conn = tl.get();
        try {
            // 2. 判断当前线程是否有连接
            if (conn == null) {
                // 3. 从数据源中获取连接
                conn = dataSource.getConnection();
                // 4. 存入ThreadLocal中
                tl.set(conn);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
