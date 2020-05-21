package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

// @ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperty {
    String driverClassName;
    String url;
    String username;
    String password;

}
