<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Trang chủ</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="home-box">

    <h1>SHOP QUẦN ÁO</h1>

    <h2>Xin chào, ${sessionScope.account.username}</h2>

    <hr>

    <a class="menu-btn" href="profile">👤 Thông tin cá nhân</a>

    <c:if test="${sessionScope.account.roleID == 1}">
        <a class="menu-btn" href="nhanvien">📋 Quản lý nhân viên</a>
    </c:if>

    <a class="logout-btn" href="logout">🚪 Đăng xuất</a>

</div>

</body>
</html>