package com.springlearning.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序键的依赖关系
 *          包括
 *              类之间的依赖
 *              方法之间的依赖
*       解耦：
 *          降低程序间的依赖关系
*       实际开发中：编译期不依赖，运行时依赖
 *      解耦思路：
 *          第一种：使用反射来创建对象，避免使用new关键字；
 *          第二种：通过读取配置文件来获取要创建的对象全限定类名。
 */

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1， 注册驱动
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        // 2, 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://172.16.36.164:3306/spring_1?characterEncoding=UTF-8", "root", "123456");
        // 3, 获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account;");
        // 4， 执行SQL语句
        ResultSet resultSet = pstm.executeQuery();
        //5, 遍历显示
        while(resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        // 6, 释放资源
        resultSet.close();
        conn.close();

    }
}
