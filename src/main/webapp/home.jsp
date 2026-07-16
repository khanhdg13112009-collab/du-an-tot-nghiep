<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Trang chủ</title>

    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="home-box">

    <h1>👔 SHOP ÁO CHO NAM</h1>

    <h2>Xin chào,
        ${sessionScope.account.username}
    </h2>

    <div class="menu">

        <a class="menu-btn"
           href="profile">

            👤 Thông tin cá nhân

        </a>

        <c:if test="${sessionScope.account.roleID == 1}">

            <a class="menu-btn"
               href="nhanvien">

                👔 Quản lý nhân viên

            </a>

            <a class="menu-btn"
               href="sanpham">

                👕 Quản lý sản phẩm

            </a>

            <a class="menu-btn"
               href="khachhang">

                🛒 Quản lý khách hàng

            </a>

        </c:if>

        <a class="menu-btn logout"
           href="logout">

            🚪 Đăng xuất

        </a>

    </div>

</div>

</body>

</html>