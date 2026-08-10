<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm biến thể sản phẩm</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BTC</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham" class="active">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Thêm biến thể sản phẩm</h1>

    <div class="table-box" style="padding:30px;max-width:700px;">

        <form action="addSanPhamChiTiet" method="post">

            <input type="hidden"
                   name="maSP"
                   value="${maSP}">

            <label>Màu sắc</label>

            <select name="maMau" required>

                <c:forEach items="${mauSacList}" var="ms">

                    <option value="${ms.maMau}">
                        ${ms.tenMau}
                    </option>

                </c:forEach>

            </select>

            <br><br>

            <label>Kích cỡ</label>

            <select name="maSize" required>

                <c:forEach items="${kichCoList}" var="kc">

                    <option value="${kc.maSize}">
                        ${kc.tenSize}
                    </option>

                </c:forEach>

            </select>

            <br><br>

            <label>Giá</label>

            <div class="input-group">

                <input type="number"
                       name="gia"
                       min="0"
                       step="1"
                       required>

                <span>VNĐ</span>

            </div>

            <br><br>

            <label>Số lượng</label>

            <input type="number"
                   name="soLuong"
                   min="0"
                   required>

            <br><br>

            <button type="submit" class="btn btn-success">

                ➕ Thêm biến thể

            </button>

            <a href="sanphamchitiet?id=${maSP}"
               class="btn btn-gray">

                ← Quay lại

            </a>

        </form>

    </div>

</div>

</body>

</html>