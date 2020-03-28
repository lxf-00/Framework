package test.java.com.mybatisLearning.test;

import com.mybatisLearning.dao.UserDao;
import com.mybatisLearning.domain.User;
import com.mybatisLearning.mybatis.io.Resources;
import com.mybatisLearning.mybatis.sqlsession.SqlSession;
import com.mybatisLearning.mybatis.sqlsession.SqlSessionFactory;
import com.mybatisLearning.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * MyBatis 入门案例
 */
public class MyBatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 1， 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2, 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        // 3, 使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        // 4, 使用SqlSession创建Dao接口的代理对象
        UserDao useDao = session.getMapper(UserDao.class);
        // 5, 使用代理对象执行方法
        List<User> all = useDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        // 6, 释放对象
        session.close();
        is.close();
    }
}
