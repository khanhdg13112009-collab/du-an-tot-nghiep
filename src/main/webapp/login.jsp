<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>

<h2>ĐĂNG NHẬP</h2>

<form action="login" method="post">

    <label>Tên đăng nhập</label><br>
    <input type="text" name="username" required>

    <br><br>

    <label>Mật khẩu</label><br>
    <input type="password" name="password" required>

    <br><br>

    <button type="submit">Đăng nhập</button>

</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

</body>
</html>