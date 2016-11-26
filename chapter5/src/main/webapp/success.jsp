<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>success</title>
</head>
<body>
    欢迎！
    <shiro:hasRole name="admin">
        管理员你好啊
    </shiro:hasRole>
    <shiro:hasPermission name="user:*">
        你拥有user:*权限
    </shiro:hasPermission>
    <shiro:hasPermission name="student:select">
        你拥有student:select权限
    </shiro:hasPermission>
</body>
</html>
