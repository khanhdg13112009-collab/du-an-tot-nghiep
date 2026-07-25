<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa biến thể sản phẩm</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham" class="active">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Sửa biến thể sản phẩm</h1>

    <div class="table-box" style="padding:30px; max-width:700px;">

        <form action="editSanPhamChiTiet" method="post">

            <input type="hidden"
                   name="maSPCT"
                   value="${spct.maSPCT}">

            <input type="hidden"
                   name="maSP"
                   value="${spct.maSP}">

            <label>Màu sắc</label>

            <select name="maMau">

                <c:forEach items="${mauSacList}" var="ms">

                    <option value="${ms.maMau}"
                        ${spct.maMau==ms.maMau?"selected":""}>

                        ${ms.tenMau}

                    </option>

                </c:forEach>

            </select>

            <br><br>

            <label>Kích cỡ</label>

            <select name="maSize">

                <c:forEach items="${kichCoList}" var="kc">

                    <option value="${kc.maSize}"
                        ${spct.maSize==kc.maSize?"selected":""}>

                        ${kc.tenSize}

                    </option>

                </c:forEach>

            </select>

            <br><br>

            <label>Giá</label>

            <input type="number"
                   name="gia"
                   value="${spct.gia}"
                   required>

            <br><br>

            <label>Số lượng</label>

            <input type="number"
                   name="soLuong"
                   value="${spct.soLuong}"
                   required>

            <br><br>

            <button type="submit" class="btn">
                💾 Cập nhật
            </button>

            <a href="sanphamchitiet?id=${spct.maSP}"
               class="btn btn-gray">

                ← Quay lại

            </a>

        </form>

    </div>

</div>

</body>

</html>