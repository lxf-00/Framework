package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class BootDemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(BootDemoApplication.class, args);
    }
}
