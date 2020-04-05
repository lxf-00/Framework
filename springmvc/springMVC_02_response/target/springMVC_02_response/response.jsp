<%--
  Created by IntelliJ IDEA.
  User: lxf
  Date: 2020/4/3
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"/user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"小张", "password":"345", "age":23}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                            alert(data.username);
                            alert(data.password);
                            alert(data.age);
                        }
                    })
            });
        });
    </script>
</head>
<body>
    <a href="/user/testString">testString</a>
    <br>
    <hr>
    <a href="/user/testVoid">testVoid</a>
    <br>
    <hr>
    <a href="/user/testModelAndView">testModelAndView</a>
    <br>
    <hr>
    <a href="/user/testForwardAndRedirect">testForwardAndRedirect</a>
    <br>
    <hr>
    <button id="btn">发送ajax异步请求</button>
</body>
</html>
