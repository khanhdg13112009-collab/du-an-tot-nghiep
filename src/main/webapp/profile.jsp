<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông tin cá nhân</title>
</head>
<body>

<h2>THÔNG TIN CÁ NHÂN</h2>

<table border="1" cellpadding="8">

    <tr>
        <td>Mã nhân viên</td>
        <td>${nv.maNV}</td>
    </tr>

    <tr>
        <td>Họ tên</td>
        <td>${nv.hoTen}</td>
    </tr>

    <tr>
        <td>Ngày sinh</td>
        <td>${nv.ngaySinh}</td>
    </tr>

    <tr>
        <td>Giới tính</td>
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
    </tr>

    <tr>
        <td>Số điện thoại</td>
        <td>${nv.soDienThoai}</td>
    </tr>

    <tr>
        <td>Email</td>
        <td>${nv.email}</td>
    </tr>

    <tr>
        <td>Địa chỉ</td>
        <td>${nv.diaChi}</td>
    </tr>

    <tr>
        <td>Trạng thái</td>
        <td>
            <c:choose>
                <c:when test="${nv.trangThaiID == 1}">
                    Đang làm
                </c:when>
                <c:otherwise>
                    Nghỉ việc
                </c:otherwise>
            </c:choose>
        </td>
    </tr>

</table>

<br>

<a href="home.jsp">Quay lại Trang chủ</a>

</body>
</html>