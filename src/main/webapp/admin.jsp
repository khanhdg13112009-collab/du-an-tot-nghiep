<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>BO THẰNG CHÁ - ADMIN</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="banHang">🛒 Bán hàng</a>

   <c:if test="${sessionScope.account.roleID == 1}">

       <a href="sanpham">👕 Quản lý sản phẩm</a>

       <a href="nhanvien">👨 Quản lý nhân viên</a>

       <a href="khachhang">👤 Quản lý khách hàng</a>

   </c:if>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="thongKe">📊 Thống kê doanh thu</a>

    <a href="/DATN-nhom2/logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Dashboard</h1>

    <h3 style="color:#9ca3af;margin-top:-5px;">

    Xin chào,

    ${sessionScope.account.username}

    👋

    </h3>

    <div class="dashboard-cards">

        <div class="card">
            <div class="icon">👕</div>
            <h3>Sản phẩm</h3>
            <p>${tongSanPham}</p>
        </div>

        <div class="card">
            <div class="icon">👤</div>
            <h3>Khách hàng</h3>
            <p>${tongKhachHang}</p>
        </div>

        <div class="card">
            <div class="icon">👨</div>
            <h3>Nhân viên</h3>
            <p>${tongNhanVien}</p>
        </div>

        <div class="card">
            <div class="icon">🧾</div>
            <h3>Hóa đơn</h3>
            <p>${tongHoaDon}</p>
        </div>

    </div>

    <div class="card-container">

        <div class="card">

            <h2>Sản phẩm</h2>

            <p>Quản lý toàn bộ sản phẩm.</p>

            <a href="sanpham">Mở</a>

        </div>

        <div class="card">

            <h2>Bán hàng</h2>

            <p>Tạo hóa đơn và thanh toán.</p>

            <a href="banHang">Mở</a>

        </div>

        <div class="card">

            <h2>Nhân viên</h2>

            <p>Quản lý nhân viên.</p>

            <a href="nhanvien">Mở</a>

        </div>

        <div class="card">

            <h2>Khách hàng</h2>

            <p>Quản lý khách hàng.</p>

            <a href="khachhang">Mở</a>

        </div>

        <div class="card">

            <h2>Hóa đơn</h2>

            <p>Quản lý hóa đơn.</p>

            <a href="hoaDon">Mở</a>

        </div>

        <div class="card">

            <h2>Thống kê doanh thu</h2>

            <p>Xem doanh thu theo ngày, tháng và năm.</p>

            <a href="thongKe">Mở</a>

        </div>

    </div>

</div>

</body>
</html>