package com.mybatisLearning.mybatis.utils;

import com.mybatisLearning.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 创建数据源
 */
public class DataSourceUtil {
    /**
     *获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
