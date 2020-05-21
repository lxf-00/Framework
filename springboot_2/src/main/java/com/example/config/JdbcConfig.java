package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
// @PropertySource("classpath:application.properties")
// @EnableConfigurationProperties(JdbcProperty.class)
public class JdbcConfig {

   /* @Value("${driverClassName}")
    String driverClassName;
    @Value("${url}")
    String url;
    @Value("${username}")
    String username;
    @Value("${password}")
    String password;*/


    /*@Bean
    public DataSource dataSource(JdbcProperty prop){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(prop.driverClassName);
        dataSource.setUrl(prop.url);
        dataSource.setUsername(prop.username);
        dataSource.setPassword(prop.password);
        return dataSource;
    }*/

//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        return dataSource;
//    }

}
