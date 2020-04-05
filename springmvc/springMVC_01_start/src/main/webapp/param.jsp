<%--
  Created by IntelliJ IDEA.
  User: lxf
  Date: 2020/4/2
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定展示页</title>
</head>
<body>
    <h3>请求参数绑定</h3>
    <%--<a href="/params/test?username=haa&password=34hg">点击跳转</a>--%>
    <%--请求参数绑定：含JavaBean类--%>
    <%--<form action="/params/saveAccount" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        姓名：<input type="text" name="user.uname"><br>
        年龄：<input type="text" name="user.age"><br>
        <input type="submit" value="提交"><br>
    </form>--%>

    <%--请求参数绑定：集合列表数据--%>
   <%-- <form action="/params/saveAccount" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        姓名：<input type="text" name="list[0].uname"><br>
        年龄：<input type="text" name="list[0].age"><br>
        姓名：<input type="text" name="map['one'].uname"><br>
        年龄：<input type="text" name="map['one'].age"><br>
        <input type="submit" value="提交"><br>
    </form>--%>

    <%--自定义类型转换器--%>
    <%--<form action="/params/saveUser" method="post">
        姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        生日：<input type="text" name="birthday"><br>
        <input type="submit" value="提交"><br>
    </form>--%>

    <%--获取原生ServletAPI--%>
    <a href="/params/testServlet">Servlet原生API</a>
</body>
</html>
