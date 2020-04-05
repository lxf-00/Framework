package com.factory.factory_test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 工厂模式进行解耦
 * 1.读取配置文件
 * 2. 反射
 * 3. 优化
 */
public class FactoryBean {
    private static Properties props;
    // 定义一个Map，用来存放我们要创建的对象
    private static Map<String, Object> beans;

    static {
        try {
            // 1, 获取配置文件流
            InputStream is = FactoryBean.class.getClassLoader().getResourceAsStream("factory.properties");
            // 2, 加载配置文件
            props = new Properties();
            props.load(is);
            // 3. 创建map集合保存
            beans = new HashMap<String, Object>();
            // 4. 获取属性的键的所有值:枚举类型
            Enumeration<Object> keys = props.keys();
            // 5. 遍历keys
            while (keys.hasMoreElements()) {
                // 取出每一个值
                String key = keys.nextElement().toString();
                System.out.println(key);
                // 根据key获取value
                String beanPath = props.getProperty(key);
                // 反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                // 将key和value存入容器
                beans.put(key, value);
            }

        } catch (IOException e) {
            throw new ExceptionInInitializerError("配置初始化错误");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object createInstance(String strName) {
        return beans.get(strName);
       /* Object in = null;
        try {
            String str = props.getProperty(strName);
            System.out.println(str);
            in = Class.forName(str).newInstance();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return in;
    }*/
    }
}
