<%--
  Created by IntelliJ IDEA.
  User: lxf
  Date: 2020/4/4
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>ssm 整合案例首页</h3>
    <a href="/account/findAll">查询所有</a>

    <form action="account/save" method="post">
        姓名：<input type="text" name="name" /><br/>
        金额：<input type="text" name="money" /><br/>
        <input type="submit" value="保存"/><br/>
    </form>
</body>
</html>
