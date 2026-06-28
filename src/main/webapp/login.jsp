<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Đăng nhập</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="login-box">

    <h1>SHOP QUẦN ÁO</h1>

    <h3>Đăng nhập hệ thống</h3>

    <form action="login" method="post">

        <label>Tên đăng nhập</label>

        <input type="text"
               name="username"
               placeholder="Nhập tên đăng nhập"
               required>

        <label>Mật khẩu</label>

        <input type="password"
               name="password"
               placeholder="Nhập mật khẩu"
               required>

        <button type="submit">Đăng nhập</button>

    </form>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

</div>

</body>

</html>