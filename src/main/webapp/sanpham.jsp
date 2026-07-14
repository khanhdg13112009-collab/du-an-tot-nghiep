<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Quản lý sản phẩm</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="nhanvien-box">

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>QUẢN LÝ SẢN PHẨM</h2>

    <a class="add-btn"
       href="addSanPham">

        ➕ Thêm sản phẩm

    </a>

    <table>

        <tr>

            <th>Mã SP</th>

            <th>Tên sản phẩm</th>

            <th>Thương hiệu</th>

            <th>Chất liệu</th>

            <th>Mô tả</th>

            <th>Trạng thái</th>

            <th>Chức năng</th>

        </tr>

        <c:forEach items="${list}" var="sp">

            <tr>

                <td>${sp.maSP}</td>

                <td>${sp.tenSP}</td>

                <td>${sp.thuongHieu}</td>

                <td>${sp.chatLieu}</td>

                <td>${sp.moTa}</td>

                <td>

                    <c:choose>

                        <c:when test="${sp.trangThai}">

                            Đang bán

                        </c:when>

                        <c:otherwise>

                            Ngừng bán

                        </c:otherwise>

                    </c:choose>

                </td>

                <td>

                    <a class="action-btn edit-btn"
                       href="editSanPham?id=${sp.maSP}">

                        ✏️ Sửa

                    </a>

                    <a class="action-btn"
                       style="background:#16a34a;"
                       href="sanphamchitiet?id=${sp.maSP}">

                        📦 Chi tiết

                    </a>

                    <a class="action-btn delete-btn"
                       href="deleteSanPham?id=${sp.maSP}"
                       onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')">

                        🗑️ Xóa

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