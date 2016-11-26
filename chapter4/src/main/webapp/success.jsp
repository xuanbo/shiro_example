<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    欢迎！
    <shiro:hasRole name="admin">
        管理员你好啊
    </shiro:hasRole>
</body>
</html>
