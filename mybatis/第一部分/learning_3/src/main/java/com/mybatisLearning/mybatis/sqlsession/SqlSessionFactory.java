package com.mybatisLearning.mybatis.sqlsession;

public interface SqlSessionFactory {
    /**
     * 打开一个新的SqlSession对像
     * @return
     */
    SqlSession openSession();
}
