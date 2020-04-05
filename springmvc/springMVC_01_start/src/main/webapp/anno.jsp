<%--
  Created by IntelliJ IDEA.
  User: lxf
  Date: 2020/4/2
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <%--常用注解： RequestParam--%>
    <a href="/anno/testRequestParam?name=哈大师">RequestParam</a>
    <br>
    <hr>
    <%--常用注解： RequestBody--%>
    <form action="/anno/testRequestBody" method="post">
        姓名：<input type="text" name="username"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
    <br>
    <%--常用注解： PathVariable--%>
    <a href="/anno/testPathVariable/10">PathVariable</a>
    <br>
    <hr>
    <%--注解：RequestHeader--%>
    <a href="/anno/testRequestHeader">RequestHeader</a>
    <br>
    <hr>
    <%--注解：CookieValue--%>
    <a href="/anno/testCookieValue">CookieValue</a>
    <br>
    <hr>
    <%--注解： ModelAttribute--%>
    <form action="/anno/testModelAttribute" method="post">
        姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <br>
    <hr>
    <%--常用注解： SessionAttribute--%>
    <a href="/anno/testSessionAttributes">存储进Request域中</a>
    <a href="/anno/getSessionAttributes">获取Session</a>
    <a href="/anno/removeSessionAttributes">移除Session中的值</a>
</body>
</html>
