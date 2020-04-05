package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * spring configuration 类  代替xml
 * 新注解：
 *      @Configuration： 指定当前类是一个配置类
 *      @ComponentScan: 通过注解指定spring在创建容器时要扫描的包
 *      @Bean:用于把当前方法的返回值作为bean对象存入spring的IoC容器中
 */
@Configuration
@ComponentScan("com.springlearning")
public class SpringConfig {
    /**
     * 创建QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name="dataSource")
    @Scope("prototype")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://172.16.36.164:3306/spring_1?characterEncoding=UTF-8");
            ds.setUser("root");
            ds.setPassword("123456");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
