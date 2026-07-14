<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Chi tiết sản phẩm</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="nhanvien-box">

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>CHI TIẾT SẢN PHẨM</h2>

    <c:if test="${not empty list}">

        <h3 style="margin-bottom:20px;">

            Sản phẩm:
            <span style="color:#2563eb;">
                ${list[0].tenSP}
            </span>

        </h3>

    </c:if>

    <a class="add-btn"
       href="addSanPhamChiTiet?maSP=${maSP}">

        ➕ Thêm biến thể

    </a>

    <table>

        <tr>

            <th>Màu sắc</th>

            <th>Kích cỡ</th>

            <th>Giá</th>

            <th>Số lượng</th>

            <th>Chức năng</th>

        </tr>

        <c:forEach items="${list}" var="spct">

            <tr>

                <td>${spct.tenMau}</td>

                <td>${spct.tenSize}</td>

                <td>${spct.gia}</td>

                <td>${spct.soLuong}</td>

                <td>

                    <a class="action-btn edit-btn"
                       href="editSanPhamChiTiet?id=${spct.maSPCT}">

                        Sửa

                    </a>

                    <a class="action-btn delete-btn"
                       href="deleteSanPhamChiTiet?id=${spct.maSPCT}"
                       onclick="return confirm('Bạn có chắc muốn xóa?')">

                        Xóa

                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a class="back-btn"
       href="sanpham">

        ← Quay lại Quản lý sản phẩm

    </a>

</div>

</body>

</html>