package com.lxf.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderUtils {

    public static void test1(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordStr = encoder.encode(password);
        System.out.println(passwordStr);
    }

    public static void main(String[] args) {
        EncoderUtils.test1("lxf");
    }
}
