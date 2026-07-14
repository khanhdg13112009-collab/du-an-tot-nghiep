<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Quản lý khách hàng</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="nhanvien-box">

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>QUẢN LÝ KHÁCH HÀNG</h2>

    <a class="add-btn"
       href="addKhachHang">

        ➕ Thêm khách hàng

    </a>

    <table>

        <tr>

            <th>Mã KH</th>

            <th>Họ tên</th>

            <th>Số điện thoại</th>

            <th>Email</th>

            <th>Địa chỉ</th>

            <th>Chức năng</th>

        </tr>

        <c:forEach items="${list}" var="kh">

            <tr>

                <td>${kh.maKH}</td>

                <td>${kh.hoTen}</td>

                <td>${kh.soDienThoai}</td>

                <td>${kh.email}</td>

                <td>${kh.diaChi}</td>

                <td>

                    <a class="action-btn edit-btn"
                       href="editKhachHang?id=${kh.maKH}">

                        Sửa

                    </a>

                    <a class="action-btn delete-btn"
                       href="deleteKhachHang?id=${kh.maKH}"
                       onclick="return confirm('Bạn có chắc muốn xóa?')">

                        Xóa

                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a class="back-btn"
       href="home.jsp">

        ← Quay lại Trang chủ

    </a>

</div>

</body>

</html>