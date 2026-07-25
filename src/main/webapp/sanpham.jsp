<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Quản lý sản phẩm</title>

   <link rel="stylesheet"
         href="${pageContext.request.contextPath}/css/admin.css">

</head>

<body>

<!-- Sidebar -->
<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham" class="active">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="logout">🚪 Đăng xuất</a>

</div>

<!-- Nội dung -->
<div class="content">

    <h1>Quản lý sản phẩm</h1>

    <div class="toolbar">

        <a href="addSanPham" class="btn btn-success">
            ➕ Thêm sản phẩm
        </a>

        <form action="sanpham" method="get">

            <input type="text"
                   name="keyword"
                   value="${keyword}"
                   placeholder="Nhập mã hoặc tên sản phẩm...">

            <button type="submit" class="btn">
                🔍 Tìm
            </button>

            <a href="sanpham" class="btn btn-gray">
                Hiển thị tất cả
            </a>

        </form>

    </div>

    <div class="table-box">

        <table>

            <tr>

                <th>Mã SP</th>

                <th>Tên sản phẩm</th>

                <th>Thương hiệu</th>

                <th>Chất liệu</th>

                <th>Mô tả</th>

                <th>Trạng thái</th>

                <th>Thao tác</th>

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
                                <span class="status-on">
                                    🟢 Đang bán
                                </span>
                            </c:when>

                            <c:otherwise>
                                <span class="status-off">
                                    🔴 Ngừng bán
                                </span>
                            </c:otherwise>

                        </c:choose>

                    </td>

                    <td>

                        <a href="editSanPham?id=${sp.maSP}"
                           class="btn">
                            ✏️ Sửa
                        </a>

                        <a href="sanphamchitiet?id=${sp.maSP}"
                           class="btn btn-success">
                            📦 Chi tiết
                        </a>

                    </td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>

</body>
</html>