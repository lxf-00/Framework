<%--
  Created by IntelliJ IDEA.
  User: lxf
  Date: 2020/4/3
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>文件上传</h3>
    <form action="/user/fileUpload1" method="post" enctype="multipart/form-data">
        上传文件： <input type="file" name="upload1">
        <input type="submit" value="上传">
    </form>

    <br>
    <form action="/user/fileUpload2" method="post" enctype="multipart/form-data">
        上传文件： <input type="file" name="upload1">
        <input type="submit" value="上传">
    </form>

    <br>
    <hr>
    <form action="/user/fileUpload3" method="post" enctype="multipart/form-data">
        上传文件： <input type="file" name="upload1">
        <input type="submit" value="上传">
    </form>
</body>
</html>
