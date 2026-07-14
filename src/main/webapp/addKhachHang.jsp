<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm khách hàng</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="form-box">

    <h2>THÊM KHÁCH HÀNG</h2>

    <form action="addKhachHang" method="post">

        <label>Họ tên</label>

        <input
                type="text"
                name="hoTen"
                required>

        <label>Số điện thoại</label>

        <input
                type="text"
                name="soDienThoai"
                required>

        <label>Email</label>

        <input
                type="email"
                name="email">

        <label>Địa chỉ</label>

        <input
                type="text"
                name="diaChi">

        <br><br>

        <button type="submit">

            Thêm khách hàng

        </button>

        <a href="khachhang">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>