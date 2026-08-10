<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Chi tiết sản phẩm</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>Btc</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham" class="active">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Chi tiết sản phẩm</h1>

    <c:if test="${not empty list}">

        <h3 style="margin-bottom:20px;">

            Sản phẩm:

            <span style="color:#2563eb;">

                ${list[0].tenSP}

            </span>

        </h3>

    </c:if>

    <div class="toolbar">

        <a href="addSanPhamChiTiet?maSP=${maSP}"
           class="btn btn-success">

            ➕ Thêm biến thể

        </a>

    </div>

    <div class="table-box">

        <table>

            <tr>

                <th>Màu sắc</th>

                <th>Kích cỡ</th>

                <th>Giá</th>

                <th>Số lượng</th>

                <th>Thao tác</th>

            </tr>

            <c:forEach items="${list}" var="spct">

                <tr>

                    <td>${spct.tenMau}</td>

                    <td>${spct.tenSize}</td>

                    <td style="text-align:right;">

                        <fmt:formatNumber
                                value="${spct.gia}"
                                pattern="#,##0"/>

                        VNĐ

                    </td>

                    <td>${spct.soLuong}</td>

                    <td>

                        <a href="editSanPhamChiTiet?id=${spct.maSPCT}"
                           class="btn">

                            ✏️ Sửa

                        </a>

                    </td>

                </tr>

            </c:forEach>

        </table>

    </div>

    <br>

    <a href="sanpham"
       class="btn btn-gray">

        ← Quay lại Quản lý sản phẩm

    </a>

</div>

</body>

</html>