<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý nhân viên</title>
</head>
<body>

<h2>DANH SÁCH NHÂN VIÊN</h2>

<table border="1">

    <tr>
        <th>Mã</th>
        <th>Họ tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>SĐT</th>
        <th>Email</th>
        <th>Địa chỉ</th>
    </tr>

    <c:forEach items="${list}" var="nv">

        <tr>

            <td>${nv.maNV}</td>

            <td>${nv.hoTen}</td>

            <td>${nv.ngaySinh}</td>

            <td>
                <c:choose>
                    <c:when test="${nv.gioiTinh}">
                        Nam
                    </c:when>

                    <c:otherwise>
                        Nữ
                    </c:otherwise>
                </c:choose>
            </td>

            <td>${nv.soDienThoai}</td>

            <td>${nv.email}</td>

            <td>${nv.diaChi}</td>

        </tr>

    </c:forEach>

</table>

<br>

<a href="home.jsp">Quay lại</a>

</body>
</html>