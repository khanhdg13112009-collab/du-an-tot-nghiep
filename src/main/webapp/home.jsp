<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
</head>
<body>

<h2>Xin chào ${sessionScope.account.username}</h2>

<br>

<a href="profile">Thông tin cá nhân</a>

<br><br>

<c:if test="${sessionScope.account.roleID == 1}">
    <a href="nhanvien">Quản lý nhân viên</a>
    <br><br>
</c:if>

<a href="logout">Đăng xuất</a>

</body>
</html>