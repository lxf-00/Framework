package com.mybatisLearning.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入的参数，获取字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        //                获取字节码    类加载器       获取配置文件输入流
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
