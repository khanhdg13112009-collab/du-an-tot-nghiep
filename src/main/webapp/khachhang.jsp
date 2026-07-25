<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Quản lý khách hàng</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang" class="active">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="/DATN-nhom2/logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Quản lý khách hàng</h1>

    <div class="toolbar">

        <a href="addKhachHang" class="btn btn-success">

            ➕ Thêm khách hàng

        </a>

    </div>

    <div class="table-box">

        <table>

            <thead>

            <tr>

                <th>Mã KH</th>

                <th>Họ tên</th>

                <th>Số điện thoại</th>

                <th>Thao tác</th>

            </tr>

            </thead>

            <tbody>

            <c:forEach items="${list}" var="kh">

                <tr>

                    <td>${kh.maKH}</td>

                    <td>${kh.hoTen}</td>

                    <td>${kh.soDienThoai}</td>

                    <td>

                        <a href="editKhachHang?id=${kh.maKH}"
                           class="btn">

                            ✏️ Sửa

                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>

</body>

</html>