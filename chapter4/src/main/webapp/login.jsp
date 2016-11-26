<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <c:if test="${not empty error}">
        <div style="color: #ff0000">
            ${error}
        </div>
    </c:if>
    <form action="/login" method="post">
        user:<input type="text" name="username" />
        password:<input type="password" name="password" />
        <button type="submit">登录</button>
    </form>
</body>
</html>
