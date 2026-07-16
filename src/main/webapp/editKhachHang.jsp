<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa khách hàng</title>

    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="form-box">

    <h2>SỬA KHÁCH HÀNG</h2>

    <form action="editKhachHang" method="post">

        <input
                type="hidden"
                name="maKH"
                value="${kh.maKH}">

        <label>Họ tên</label>

        <input
                type="text"
                name="hoTen"
                value="${kh.hoTen}"
                required>

        <label>Số điện thoại</label>

        <input
                type="text"
                name="soDienThoai"
                value="${kh.soDienThoai}"
                required>

        <label>Email</label>

        <input
                type="email"
                name="email"
                value="${kh.email}">

        <label>Địa chỉ</label>

        <input
                type="text"
                name="diaChi"
                value="${kh.diaChi}">

        <br><br>

        <button type="submit">

            Cập nhật

        </button>

        <a href="khachhang">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>